package com.yourcompany.devicemanager.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.yourcompany.devicemanager.data.AppDatabase
import com.yourcompany.devicemanager.model.Device
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DeviceViewModel(application: Application) : AndroidViewModel(application) {
    private val deviceDao = AppDatabase.getDatabase(application).deviceDao()
    
    val allDevices: StateFlow<List<Device>> = deviceDao.getAllDevices()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addDevice(name: String, type: String, status: String) {
        viewModelScope.launch {
            val newDevice = Device(
                name = name,
                type = type,
                status = status,
                lastActive = "Just now"
            )
            deviceDao.insertDevice(newDevice)
        }
    }

    fun deleteDevice(device: Device) {
        viewModelScope.launch {
            deviceDao.deleteDevice(device)
        }
    }
}

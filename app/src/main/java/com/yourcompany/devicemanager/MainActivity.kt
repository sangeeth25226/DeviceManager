package com.yourcompany.devicemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.yourcompany.devicemanager.ui.screens.DeviceListScreen
import com.yourcompany.devicemanager.ui.theme.MyApplicationTheme
import com.yourcompany.devicemanager.viewmodel.DeviceViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: DeviceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val devices by viewModel.allDevices.collectAsState()
                
                DeviceListScreen(
                    devices = devices,
                    onAddDeviceClick = {
                        // For now, adding a test device to verify DB works
                        viewModel.addDevice("New Device ${devices.size + 1}", "Sensor", "Online")
                    }
                )
            }
        }
    }
}

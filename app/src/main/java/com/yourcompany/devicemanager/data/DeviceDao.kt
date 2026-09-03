package com.yourcompany.devicemanager.data

import androidx.room.*
import com.yourcompany.devicemanager.model.Device
import kotlinx.coroutines.flow.Flow

@Dao
interface DeviceDao {
    @Query("SELECT * FROM devices ORDER BY name ASC")
    fun getAllDevices(): Flow<List<Device>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDevice(device: Device)

    @Delete
    suspend fun deleteDevice(device: Device)

    @Update
    suspend fun updateDevice(device: Device)
}

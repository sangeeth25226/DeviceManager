package com.yourcompany.devicemanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yourcompany.devicemanager.model.sampleDevices
import com.yourcompany.devicemanager.ui.screens.DeviceListScreen
import com.yourcompany.devicemanager.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                DeviceListScreen(devices = sampleDevices)
            }
        }
    }
}

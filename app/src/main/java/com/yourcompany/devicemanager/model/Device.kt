package com.yourcompany.devicemanager.model

data class Device(
    val id: Int,
    val name: String,
    val type: String,
    val status: String,
    val lastActive: String
)

// Sample data for the UI preview
val sampleDevices = listOf(
    Device(1, "Main Server", "Server", "Online", "2 mins ago"),
    Device(2, "Office Router", "Networking", "Online", "Just now"),
    Device(3, "Storage NAS", "Storage", "Offline", "3 hours ago"),
    Device(4, "Development PC", "Workstation", "Online", "15 mins ago"),
    Device(5, "Backup Drive", "Storage", "Online", "1 day ago")
)

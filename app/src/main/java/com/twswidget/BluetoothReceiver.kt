package com.twswidget

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BluetoothReceiver : BroadcastReceiver() {
    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        val device: BluetoothDevice? = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)

        when (action) {
            BluetoothDevice.ACTION_ACL_CONNECTED -> {
                val deviceName = device?.name ?: "Unknown Device"
                // Change "My TWS Name" to your actual earbuds Bluetooth name
                if (deviceName.contains("My TWS Name", ignoreCase = true)) {
                    Toast.makeText(context, "Connected: $deviceName", Toast.LENGTH_SHORT).show()
                }
            }
            BluetoothDevice.ACTION_ACL_DISCONNECTED -> {
                val deviceName = device?.name ?: "Unknown Device"
                if (deviceName.contains("My TWS Name", ignoreCase = true)) {
                    Toast.makeText(context, "Disconnected: $deviceName", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}


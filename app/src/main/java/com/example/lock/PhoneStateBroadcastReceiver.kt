package com.example.lock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.WIFI_SERVICE
import android.content.Intent
import android.net.wifi.WifiManager
import android.widget.Toast

/**
 * Created by tho nguyen on 25/03/2023.
 */
class PhoneStateBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (Intent.ACTION_USER_PRESENT == intent.action) {
            val wifiManager =
                context.applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
            wifiManager.isWifiEnabled = true
            Toast.makeText(context, "wifi on", Toast.LENGTH_SHORT).show()
        }
    }
}
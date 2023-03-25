package com.example.lock

import android.app.Activity
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Bundle
import android.os.PowerManager
import android.os.SystemClock
import android.widget.Toast


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if (checkIsAdmin().not()) {
//            finish()
//            return
//        }

        val wifiManager = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
        wifiManager.isWifiEnabled = false
        Toast.makeText(this, "wifi off", Toast.LENGTH_SHORT).show()

//        lock()
        finish()
    }

    private fun lock() {
        val deviceManger = getSystemService(DEVICE_POLICY_SERVICE) as DevicePolicyManager
        deviceManger.lockNow()
    }

    private fun checkIsAdmin(): Boolean {
        val deviceManger = getSystemService(DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val compName = ComponentName(this, DeviceAdmin::class.java)
        val admin = deviceManger.isAdminActive(compName)
        if (admin.not()) {
            val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, compName)
            intent.putExtra(
                DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                "If you only activate, this app can perform screen off !!!"
            )
            startActivityForResult(intent, 100)
            return false
        }
        return true
    }

}





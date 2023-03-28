package com.example.lock


import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class LockAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event?.let {
            if (event.eventType == AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED &&
                event.text?.contains(LOCK_SCREEN) == true
            ) {
                lockDevice()
            }
        }
    }

    private fun lockDevice() {
        performGlobalAction(8)
    }

    override fun onInterrupt() {

    }
}

package com.talkon.uz.utils

import android.app.Activity
import android.content.Context
import android.provider.Settings
import android.view.Gravity
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToast.Companion.LONG_DURATION

object Utils {
    fun getDeviceID(context: Context): String {
        val device_id: String =
            Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        return device_id
    }

    fun datePickerDialog() {

    }

    fun toast(context: Activity, text: String, isSuccess: Boolean) {
        var type: String = if (isSuccess) MotionToast.TOAST_SUCCESS else MotionToast.TOAST_ERROR

        MotionToast.createColorToast(context,
            text,
            type,
            Gravity.CENTER,
            LONG_DURATION,
            null)


    }

}

interface DialogListener {
    fun onCallback(isChosen: Boolean)
}
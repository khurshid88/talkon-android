package com.talkon.uz.manager

import android.content.Context
import androidx.core.content.edit

class SharedPref(context: Context) {
    private val pref = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

    var isSaved:Boolean
    get() = pref.getBoolean("isSaved", false)
    set(value) = pref.edit { this.putBoolean("isSaved", value) }

}
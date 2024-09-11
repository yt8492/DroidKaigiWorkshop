package com.jetbrains.workshop

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

val context get() = ContextHelper.currentContext!!

private const val PREF_NAME = "Storage"
private val pref: SharedPreferences by lazy {
    context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
}

actual fun persistString(key: String, value: String) {
    pref.edit()
        .putString(key, value)
        .apply()
}

actual fun restoreString(key: String): String? {
    return pref.getString(key, "")
}

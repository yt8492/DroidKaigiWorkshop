package com.jetbrains.workshop

import kotlinx.browser.window
import org.w3c.dom.get

actual fun persistString(key: String, value: String) {
    window.localStorage.setItem(key, value)
}

actual fun restoreString(key: String): String? {
    return window.localStorage[key]
}

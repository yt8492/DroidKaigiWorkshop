package com.jetbrains.workshop

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    println("main")
    ComposeViewport(document.body!!) {
        App()
    }
}
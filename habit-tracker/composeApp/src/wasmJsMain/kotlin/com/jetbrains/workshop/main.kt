package com.jetbrains.workshop

import androidx.compose.material.Typography
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.window.ComposeViewport
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.noto_sans_jp_bold
import kotlinproject.composeapp.generated.resources.noto_sans_jp_reguar
import kotlinx.browser.document
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        App(
            typegraphy = Typography(
                defaultFontFamily = FontFamily(
                    Font(
                        resource = Res.font.noto_sans_jp_reguar,
                    ),
                    Font(
                        resource = Res.font.noto_sans_jp_bold,
                        weight = FontWeight.Bold,
                    )
                )
            )
        )
    }
}
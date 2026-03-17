package com.example.vkeducationandroidkotlin.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = RuStoreBlue,
    secondary = RuStorePurple,
    tertiary = RuStoreMagenta,

    background = RuStoreBlack,
    surface = RuStoreBlack,

    onPrimary = RuStoreWhite,
    onSecondary = RuStoreWhite,
    onTertiary = RuStoreWhite,

    onBackground = RuStoreWhite,
    onSurface = RuStoreWhite,

    outline = RuStoreGray
)

private val LightColorScheme = lightColorScheme(
    primary = RuStoreBlue,
    secondary = RuStorePurple,
    tertiary = RuStoreMagenta,

    background = RuStoreWhite,
    surface = RuStoreWhite,

    onPrimary = RuStoreWhite,
    onSecondary = RuStoreWhite,
    onTertiary = RuStoreWhite,

    onBackground = RuStoreBlack,
    onSurface = RuStoreBlack,

    outline = RuStoreGray
)

@Composable
fun VKEducationAndroidKotlinTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
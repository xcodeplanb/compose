package com.makeshop.podbbang.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

class NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor(): Color = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(
        draggedAlpha = 0f,
        focusedAlpha = 0f,
        hoveredAlpha = 0f,
        pressedAlpha = 0f,
    )
}

private val LightColorsScheme = lightColors(
    primary = Color121212,
    primaryVariant = Color121212,
    secondary = Color1A1A1A,
    secondaryVariant = Color1A1A1A,
)

private val darkColorsScheme = darkColors(
    primary = Color121212,
    primaryVariant = Color121212,
    secondary = Color1A1A1A,
    secondaryVariant = Color1A1A1A
)

@SuppressLint("NewApi")
@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    isDynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val myColorScheme = when {
        isDarkTheme -> darkColorsScheme
        else -> LightColorsScheme
    }

    MaterialTheme(
        colors = myColorScheme,
        typography = appTypography
    ) {
        CompositionLocalProvider(
            LocalRippleTheme provides NoRippleTheme(),
            content = content
        )

    }
}
package com.makeshop.podbbang.mobile.ui.theme

import android.os.Build
import androidx.annotation.ColorRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val Color121212 = Color(0xFF121212)
val Color1A1A1A = Color(0xFF1A1A1A)
val Color666666 = Color(0xFF666666)
val Color1FA1EB = Color(0xFF1FA1EB)
val ColorFFFFFF = Color(0xFFFFFFFF)
val Color1AFFFFFF = Color(0x1AFFFFFF)
val ColorFFCCCCCC = Color(0xFFCCCCCC)
val ColorFFFEFEFE = Color(0xFFFEFEFE)
val Color000000 = Color(0xFF000000)

@Composable
fun themeColors() : CustomColorsPalette {
    val customColorsPalette =
        if (isSystemInDarkTheme()) {
            OnDarkCustomColorsPalette
        } else {
            OnLightCustomColorsPalette
        }
    return customColorsPalette
}

//
//@Immutable
data class CustomColorsPalette(
    val light121212DarkFFFFFF: Color = Color.Unspecified,
    val light1FA1EBDark46BBFF: Color = Color.Unspecified
)

val OnLightCustomColorsPalette = CustomColorsPalette(
    light121212DarkFFFFFF = Color(color = 0xFF1A237E),
    light1FA1EBDark46BBFF = Color(color = 0xFF1B5E20)
)

val OnDarkCustomColorsPalette = CustomColorsPalette(
    light121212DarkFFFFFF = Color(color = 0xFF1E88E5),
    light1FA1EBDark46BBFF = Color(color = 0xFF43A047)
)

val LocalCustomColorsPalette = staticCompositionLocalOf { CustomColorsPalette() }

@Composable
@ReadOnlyComposable
fun colorResource(@ColorRes id: Int): Color {
    val context = LocalContext.current
    return Color(context.resources.getColor(id))
}
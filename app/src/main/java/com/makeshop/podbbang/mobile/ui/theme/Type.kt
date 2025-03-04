package com.makeshop.podbbang.mobile.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.makeshop.podbbang.mobile.R

val spoqa_hansans_neo_regular = FontFamily(
    Font(R.font.spoqa_hansans_neo_regular, FontWeight(500))
)

val appTypography = Typography (
    defaultFontFamily = spoqa_hansans_neo_regular
)

val normalFont = TextStyle(
    fontFamily = spoqa_hansans_neo_regular,
    fontWeight = FontWeight(400),
    platformStyle = PlatformTextStyle(
        includeFontPadding = true
    ),
)
val boldFont = TextStyle(
    fontFamily = spoqa_hansans_neo_regular,
    fontWeight = FontWeight(700),
    platformStyle = PlatformTextStyle(
        includeFontPadding = true
    )
)

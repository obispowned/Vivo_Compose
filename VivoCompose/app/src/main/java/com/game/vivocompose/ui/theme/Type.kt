package com.game.vivocompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.game.vivocompose.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )




    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
val gotham = FontFamily(
    Font(R.font.gothambook),
    Font(R.font.gothambold, FontWeight.Bold)
)

@ExperimentalUnitApi
val VivoTypography = Typography(
    h6 = TextStyle(
        fontFamily = gotham,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        letterSpacing = TextUnit(0.15f, TextUnitType.Sp)
    ),
    body1 = TextStyle(
        fontFamily = gotham,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        letterSpacing = TextUnit(0.5f, TextUnitType.Sp)
    ),
    button = TextStyle(
        fontFamily = gotham,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        letterSpacing = TextUnit(1.25f, TextUnitType.Sp)
    )
)
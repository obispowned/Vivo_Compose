package com.game.vivocompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.ExperimentalUnitApi

private val DarkColorPalette = darkColors(/*
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,

    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
*/
/*
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
*/

)

private val LightColorPalette = lightColors(
    primary = Color_Primary,
    primaryVariant = Color_Primary2,
    onPrimary = Color.Black,

    secondary = Color_Secondary,
    secondaryVariant = Color_Secondary2,
    onSecondary = Color.Green,

    background = Color_Background,
    onBackground = Color_Neutral_Dark,
    surface = Color_Background,
    onSurface = Color_Neutral_Dark,

    error = Color.Red
)

@OptIn(ExperimentalUnitApi::class)
@Composable
fun VivoComposeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        LightColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = VivoTypography,
        shapes = Shapes,
        content = content
    )
}
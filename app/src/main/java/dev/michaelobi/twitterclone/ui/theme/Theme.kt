package dev.michaelobi.twitterclone.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightColorPalette = lightColors(
    primary = TwitterBlue,
    primaryVariant = TwitterBlue,
    secondary = TwitterBlue,
    surface = Color.White,
    onSurface = TwitterBlueGray,

    /* Other default colors to override
    background = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,

    */
)

@Composable
fun TwitterCloneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
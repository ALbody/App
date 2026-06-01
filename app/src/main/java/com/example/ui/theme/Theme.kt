package com.example.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val CosmicBackground = Color(0xFF0F0D13)
val CosmicSurface = Color.White.copy(alpha = 0.05f)
val CosmicSurfaceVariant = Color.White.copy(alpha = 0.05f)
val CosmicPrimary = Color(0xFFD0BCFF)
val CosmicPrimaryContainer = Color(0xFF4F378B)
val CosmicSecondary = Color(0xFFD0BCFF)
val CosmicError = Color(0xFFFF897D)
val CosmicOnBackground = Color(0xFFF1F5F9) // text-slate-100

private val DarkColorScheme = darkColorScheme(
    primary = CosmicPrimary,
    primaryContainer = CosmicPrimaryContainer,
    secondary = CosmicSecondary,
    background = CosmicBackground,
    surface = CosmicSurface,
    surfaceVariant = CosmicSurfaceVariant,
    error = CosmicError,
    onPrimary = CosmicBackground,
    onSecondary = CosmicBackground,
    onBackground = CosmicOnBackground,
    onSurface = CosmicOnBackground,
    onSurfaceVariant = Color(0xFFAAAABB)
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false, // Disable dynamic color for consistent aesthetic
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            window.navigationBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

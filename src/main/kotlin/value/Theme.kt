package value

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

// Color set
val LightTheme = lightColors(
    primary = R.color.primary,
    onPrimary = R.color.white,
    secondary = R.color.secondary,
    onSecondary = R.color.white,
    surface = R.color.darkgrey,
    error = R.color.darkgrey
)
val DarkTheme = darkColors(
    primary = R.color.primary,
    onPrimary = R.color.white,
    secondary = R.color.secondary,
    onSecondary = R.color.white,
    surface = R.color.darkgrey,
    error = R.color.darkgrey
)

@Composable
fun MyAppTheme(
    isDark: Boolean = true, // TODO: If you want to support both light theme and dark theme, you'll need to implement it manually.
    content: @Composable ColumnScope.() -> Unit,
) {
    MaterialTheme(
        colors = if (isDark) DarkTheme else LightTheme,
        typography = MyAppTypography
    ) {
        Surface {
            Column {
                content()
            }
        }
    }
}

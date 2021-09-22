import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import value.R

@Composable
fun logo() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(R.string.flavorName, color = R.color.darkgrey)
    }
}

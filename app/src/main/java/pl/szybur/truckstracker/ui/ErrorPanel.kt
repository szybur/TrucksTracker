package pl.szybur.truckstracker.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ErrorPanel(
    result: Result<*>,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Error fetching data ${result.exceptionOrNull()?.message}",
        modifier = modifier
    )
}
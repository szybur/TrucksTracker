package pl.szybur.truckstracker.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.szybur.truckstracker.data.api.VehicleDetails
import pl.szybur.truckstracker.data.api.isNearTarget

@Composable
fun TrucksStatusPanel(
    trucks: List<VehicleDetails>,
    modifier: Modifier
) {
    Text(
        text = "Trucks that are close: ${trucks.filter { it.location.isNearTarget }.size}",
        modifier = modifier
    )
}
package pl.szybur.truckstracker.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.szybur.truckstracker.data.api.OLYMPIC_MUSEUM
import pl.szybur.truckstracker.data.api.VehicleDetails
import pl.szybur.truckstracker.data.api.isNearTarget
import pl.szybur.truckstracker.ui.theme.TrucksTrackerTheme

@Composable
fun TruckItem(vehicleDetails: VehicleDetails,
              onClick: (VehicleDetails) -> Unit,
              modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        onClick = { onClick(vehicleDetails) }
    ) {
        Row {
            Text(
                text = vehicleDetails.vehicleId,
                modifier = modifier.padding(horizontal = 4.dp),
            )
            if (vehicleDetails.location.isNearTarget) {
                Text(
                    text = "close",
                    color = Color.Green,
                    modifier = modifier.padding(horizontal = 4.dp),
                )
            } else {
                Text(
                    text = "far away",
                    color = Color.Red,
                    modifier = modifier.padding(horizontal = 4.dp),
                )
            }

        }
    }
}

@Preview
@Composable
fun TruckItemPreview() {
    TrucksTrackerTheme {
        TruckItem(
            vehicleDetails = VehicleDetails(
                vehicleId = "3131-lknldcw-231212",
                location = OLYMPIC_MUSEUM
            ),
            onClick = {}
        )
    }
}

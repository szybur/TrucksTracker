package pl.szybur.truckstracker.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
fun TruckDetailsPanel(
    details: VehicleDetails,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = "Truck details:",
            modifier = modifier.padding(vertical = 4.dp),
        )
        Text(
            text = "Id: ${details.vehicleId}",
            modifier = modifier.padding(vertical = 4.dp),
        )
        Text(
            text = "Latitude: ${details.location.latitude}",
            modifier = modifier.padding(vertical = 4.dp),
        )
        Text(
            text = "Longitude: ${details.location.longitude}",
            modifier = modifier.padding(vertical = 4.dp),
        )
        Row {
            Text(
                text = "Is near target: ",
                modifier = modifier,
            )
            if (details.location.isNearTarget) {
                Text(
                    text = "yes",
                    color = Color.Green,
                    modifier = modifier.padding(horizontal = 4.dp),
                )
            } else {
                Text(
                    text = "no",
                    color = Color.Red,
                    modifier = modifier.padding(horizontal = 4.dp),
                )
            }
        }

    }
}

@Preview
@Composable
fun TruckDetailsPanelPreview() {
    TrucksTrackerTheme {
        TruckDetailsPanel(
            details = VehicleDetails("3232-jkkjkj", OLYMPIC_MUSEUM)
        )
    }
}
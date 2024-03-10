package pl.szybur.truckstracker.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.szybur.truckstracker.data.api.LONDON
import pl.szybur.truckstracker.data.api.OLYMPIC_MUSEUM
import pl.szybur.truckstracker.data.api.PIOTRKOWSKA
import pl.szybur.truckstracker.data.api.VehicleDetails
import pl.szybur.truckstracker.ui.theme.TrucksTrackerTheme

@Composable
fun TrucksList(
    vehicles: List<VehicleDetails>,
    onClick: (VehicleDetails) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = vehicles) { item ->
            TruckItem(vehicleDetails = item, modifier = modifier, onClick = { onClick(item) })
        }
    }
}

@Preview
@Composable
fun TrucksListPreview() {
    TrucksTrackerTheme {
        TrucksList(vehicles = listOf(
            VehicleDetails(vehicleId = "iojhn-87629", location = PIOTRKOWSKA),
            VehicleDetails(vehicleId = "lnbtw-90876", location = OLYMPIC_MUSEUM),
            VehicleDetails(vehicleId = "qacde-09517", location = LONDON)
        ),
        onClick = {})
    }
}
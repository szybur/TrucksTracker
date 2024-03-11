package pl.szybur.truckstracker.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import pl.szybur.truckstracker.ui.viewmodels.DetailsViewModel

@Composable
fun DetailsScreen(modifier: Modifier = Modifier) {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()
    val trucksResult = detailsViewModel.trucks.collectAsState(
        initial = Result.success(listOf()),
        scope.coroutineContext
    ).value
    if (trucksResult.isSuccess) {
        val trucksList = trucksResult.getOrDefault(listOf())
        val selectedTruck = trucksList.find { it.vehicleId == detailsViewModel.selectedId }
        Column {
            TrucksStatusPanel(trucks = trucksList, modifier = modifier.padding(4.dp))
            selectedTruck?.let {
                TruckDetailsPanel(details = it, modifier = modifier)
            }
        }
    } else {
        ErrorPanel(result = trucksResult, modifier = modifier)
    }
}
package pl.szybur.truckstracker.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import pl.szybur.truckstracker.data.api.VehicleDetails
import pl.szybur.truckstracker.ui.viewmodels.TrucksViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClick: (VehicleDetails) -> Unit,
) {
    val trucksViewModel: TrucksViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()
    val trucksResult = trucksViewModel.trucks.collectAsState(
        initial = Result.success(listOf()),
        scope.coroutineContext
    ).value
    if (trucksResult.isSuccess) {
        val trucksList = trucksResult.getOrDefault(listOf())
        Column {
            TrucksStatusPanel(trucks = trucksList, modifier = modifier.padding(4.dp))
            TrucksList(
                vehicles = trucksList,
                onClick = onClick,
                modifier = modifier
            )
        }
    } else {
        ErrorPanel(result = trucksResult, modifier = modifier)
    }
}
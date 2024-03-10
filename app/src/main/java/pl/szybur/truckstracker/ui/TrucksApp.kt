package pl.szybur.truckstracker.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.szybur.truckstracker.data.api.VehicleDetails
import pl.szybur.truckstracker.data.api.isNearTarget
import pl.szybur.truckstracker.ui.viewmodels.TrucksViewModel

@Composable
fun TrucksApp() {
    val trucksViewModel: TrucksViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()
    val trucksResult = trucksViewModel.trucks.collectAsState(
        initial = Result.success(listOf()),
        scope.coroutineContext
    ).value
    if (trucksResult.isSuccess) {
        val trucksList = trucksResult.getOrDefault(listOf())
        val navController = rememberNavController()
        TrucksNavHost(navController = navController, trucksList = trucksList)
    } else {
        Text(text = "Error fetching data ${trucksResult.exceptionOrNull()?.message}")
    }
}

@Composable
fun TrucksNavHost(
    navController: NavHostController,
    trucksList: List<VehicleDetails>
) {
    Column {
        Text(
            text = "Trucks that are close: ${trucksList.filter { it.location.isNearTarget }.size}",
            modifier = Modifier.padding(4.dp)

        )
        NavHost(navController = navController, startDestination = Screen.Home.route) {
            composable(route = Screen.Home.route) {
                TrucksList(
                    vehicles = trucksList,
                    onClick = {}
                )
            }
        }
    }
}
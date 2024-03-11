package pl.szybur.truckstracker.ui

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import pl.szybur.truckstracker.data.api.VehicleDetails

sealed class Screen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    data object Home : Screen("home")

    data object Details : Screen(
        route = "details/{$ID_PARAM}",
        navArguments = listOf(navArgument(ID_PARAM) {
            type = NavType.StringType
        })
    ) {
        fun createRoute(details: VehicleDetails) = "details/${details.vehicleId}"
    }
}

const val ID_PARAM = "id"
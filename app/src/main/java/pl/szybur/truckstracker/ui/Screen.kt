package pl.szybur.truckstracker.ui

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.gson.Gson
import pl.szybur.truckstracker.data.api.VehicleDetails

sealed class Screen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    data object Home : Screen("home")

    data object Details : Screen(
        route = "details/{item}",
        navArguments = listOf(navArgument("item") {
            type = NavType.StringType
        })
    ) {
        fun createRoute(details: VehicleDetails) = "details/${Gson().toJson(details)}"
    }
}
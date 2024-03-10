package pl.szybur.truckstracker.ui

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    data object Home : Screen("home")

    /*data object Details : Screen(
        route = "details/{login}",
        navArguments = listOf(navArgument("login") {
            type = NavType.StringType
        })
    ) {
        fun createRoute(login: String) = "details/${login}"
    }*/
}
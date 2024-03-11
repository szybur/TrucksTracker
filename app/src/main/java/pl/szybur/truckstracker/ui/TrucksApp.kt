package pl.szybur.truckstracker.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun TrucksApp() {
    val navController = rememberNavController()
    TrucksNavHost(navController = navController)

}

@Composable
fun TrucksNavHost(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(onClick = {
                navController.navigate(
                    Screen.Details.createRoute(it)
                )
            })
        }
        composable(
            route = Screen.Details.route,
            arguments = Screen.Details.navArguments
        ) {
            DetailsScreen()
        }
    }
}
package com.example.wintertravelgallery.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.wintertravelgallery.data.Destination
import com.example.wintertravelgallery.ui.GalleryScreen
import com.example.wintertravelgallery.ui.HomeScreen

@Composable
fun WinterTravelNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination= Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onDestinationClicked = { destination ->
                    navController.navigate(
                        route = Screen.Gallery.createRoute(destination.name)
                    )
                }
            )
        }
        composable(
            route = Screen.Gallery.route,
            arguments = listOf(navArgument("destinationTitle") { type = NavType.StringType })
        ) { backStackEntry ->
            val destinationTitle = backStackEntry.arguments?.getString("destinationTitle")
            val destination = Destination.valueOf(destinationTitle ?: "ALPS")
            GalleryScreen(
                destination = destination,
                navController = navController
            )
        }
    }
}

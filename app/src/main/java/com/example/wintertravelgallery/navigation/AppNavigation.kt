package com.example.wintertravelgallery.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wintertravelgallery.ui.GalleryScreen
import com.example.wintertravelgallery.ui.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination= Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onDestinationClicked = { destinationTitle ->
                    navController.navigate(
                        route = Screen.Gallery.createRoute(destinationTitle)
                    )
                }
            )
        }
        composable(
            route = Screen.Gallery.route,
            arguments = listOf(
                navArgument("destinationTitle") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val destinationTitle =
                backStackEntry.arguments?.getString("destinationTitle") ?: ""
            GalleryScreen(
                destinationName = destinationTitle,
                onNavigationBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}

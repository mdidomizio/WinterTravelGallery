package com.example.wintertravelgallery.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Gallery : Screen("gallery/{destinationTitle}") {
        fun createRoute(destinationTitle: String) = "gallery/$destinationTitle"
    }
}

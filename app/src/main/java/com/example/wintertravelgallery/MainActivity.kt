package com.example.wintertravelgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wintertravelgallery.ui.HomeScreen
import com.example.wintertravelgallery.ui.theme.WinterTravelGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WinterTravelGalleryTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(
                            onDestinationClicked = { destination ->
                                navController.navigate("gallery/${destination.name}")
                            }
                        )
                    }
                }

            }
        }
    }
}

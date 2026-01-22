package com.example.wintertravelgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.wintertravelgallery.navigation.NavigationRoot
import com.example.wintertravelgallery.navigation.WinterTravelNavHost
import com.example.wintertravelgallery.ui.theme.WinterTravelGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WinterTravelGalleryTheme {
                NavigationRoot(
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

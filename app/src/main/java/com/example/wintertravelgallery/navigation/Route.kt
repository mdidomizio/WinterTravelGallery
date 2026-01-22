package com.example.wintertravelgallery.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Route: NavKey {

    @Serializable
    data object Home: Route, NavKey

    @Serializable
    data class Gallery (val destinationTitle: String): Route, NavKey
}

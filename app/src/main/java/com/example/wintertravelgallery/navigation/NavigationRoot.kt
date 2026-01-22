package com.example.wintertravelgallery.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
// import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.example.wintertravelgallery.ui.GalleryScreen
import com.example.wintertravelgallery.ui.HomeScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic


@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
){
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration {
            serializersModule = SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Route.Home::class, Route.Home.serializer())
                    subclass(Route.Gallery::class, Route.Gallery.serializer())
                }
            }
        },
        Route.Home
    )
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
           // rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = { key ->
            when(key) {
                is Route.Home -> {
                    NavEntry(key) {
                        HomeScreen(
                            onDestinationClicked = {
                            backStack.add(Route.Gallery(it))
                            }
                        )
                    }}
                is Route.Gallery -> {
                    NavEntry(key) {
                        GalleryScreen (
                            destination = key.destinationTitle
                        )
                }
                }
                else -> error("Unknown Nav key $key")
            }
        }
    )
}

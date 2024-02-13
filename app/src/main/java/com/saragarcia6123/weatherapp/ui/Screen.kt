package com.saragarcia6123.weatherapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    data object Home: Screen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    data object Search: Screen(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )
    data object Map: Screen(
        route = "map",
        title = "Map",
        icon = Icons.Default.LocationOn
    )
    data object Settings: Screen(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )

    data object About: Screen(
        route = "about",
        title = "About",
        icon = Icons.Default.Info
    )

}
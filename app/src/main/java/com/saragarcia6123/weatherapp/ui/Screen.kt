package com.saragarcia6123.weatherapp.ui

sealed class Screen(val route: String) {
    object HomeScreen: Screen(route = "home_screen")
    object SearchScreen: Screen(route = "search_screen")
    object MapScreen: Screen(route = "map_screen")
    object InfoScreen: Screen(route = "info_screen")
    object SettingsScreen: Screen(route = "settings_screen")

}
package com.saragarcia6123.weatherapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.saragarcia6123.weatherapp.screens.HomeScreen
import com.saragarcia6123.weatherapp.screens.MapScreen
import com.saragarcia6123.weatherapp.screens.SearchScreen

@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
        composable(route = Screen.Search.route) {
            SearchScreen()
        }
        composable(route = Screen.Map.route) {
            MapScreen()
        }
    }
}
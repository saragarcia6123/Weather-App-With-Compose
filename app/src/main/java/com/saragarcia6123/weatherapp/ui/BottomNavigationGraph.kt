package com.saragarcia6123.weatherapp.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.saragarcia6123.weatherapp.screens.AboutScreen
import com.saragarcia6123.weatherapp.screens.HomeScreen
import com.saragarcia6123.weatherapp.screens.MapScreen
import com.saragarcia6123.weatherapp.screens.SearchScreen
import com.saragarcia6123.weatherapp.screens.SettingsScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun BottomNavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController, scaffoldState, scope = scope, modifier = modifier)
        }
        composable(route = Screen.Search.route) {
            SearchScreen(navController, modifier = modifier)
        }
        composable(route = Screen.Map.route) {
            MapScreen(navController, modifier = modifier)
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen(navController, modifier = modifier)
        }
        composable(route = Screen.About.route) {
            AboutScreen(navController, modifier = modifier)
        }
    }
}
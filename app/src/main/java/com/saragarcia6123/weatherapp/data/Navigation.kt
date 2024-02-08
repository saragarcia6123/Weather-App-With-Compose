package com.saragarcia6123.weatherapp.data

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saragarcia6123.weatherapp.ui.Screen

//Each screen is its own composable
//Nav host (this Navigation class) takes these composables and replace them with another
//eg click on button, ask nav to (screen name)

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {}
    }
}
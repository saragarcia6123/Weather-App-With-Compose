package com.saragarcia6123.weatherapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun AboutScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Column {
        Text(text = "About")
    }
}
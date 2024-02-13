package com.saragarcia6123.weatherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.saragarcia6123.weatherapp.ui.SearchBar
import com.saragarcia6123.weatherapp.ui.theme.Secondary

@Composable
fun SearchScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Secondary)
    ) {
        SearchBar(navController = navController)
    }
}

@Preview
@Composable
fun Preview() {
    SearchScreen(navController = rememberNavController())
}


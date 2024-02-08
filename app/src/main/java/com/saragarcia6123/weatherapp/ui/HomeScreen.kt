package com.saragarcia6123.weatherapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Column {
        TextField(value = text, onValueChange = {
            text = it
        })
    }
}
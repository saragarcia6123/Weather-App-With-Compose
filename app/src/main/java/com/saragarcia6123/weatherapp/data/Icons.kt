package com.saragarcia6123.weatherapp.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.weatherappwithcompose.R


object IconUtils {
    @Composable
    fun getIconPainters(): List<Painter> {
        return listOf(
            painterResource(id = R.drawable.cloudy),
            painterResource(id = R.drawable.sunny),
            painterResource(id = R.drawable.sun),
            painterResource(id = R.drawable.drizzle),
            painterResource(id = R.drawable.fog),
            painterResource(id = R.drawable.rainy),
            // Add more icons as needed
        )
    }
}
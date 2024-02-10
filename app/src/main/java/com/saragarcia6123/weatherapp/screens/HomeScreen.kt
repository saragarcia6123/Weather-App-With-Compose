package com.saragarcia6123.weatherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.saragarcia6123.weatherapp.ui.HourlyForecastCard
import com.saragarcia6123.weatherapp.ui.TopBar
import com.saragarcia6123.weatherapp.ui.WeeklyForecastCard
import com.saragarcia6123.weatherapp.ui.theme.Secondary

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .background(Secondary)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar()
        HomeScreenContent()
    }
}

@Composable
private fun HomeScreenContent(modifier: Modifier = Modifier) {
    val list = listOf(
        "Time", "Temperature",  "Condition", "Hourly", "Weekly"
    )
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        items(items = list, itemContent = { item ->
            when (item) {
                "Time" -> {
                    Text(text = "13:48 GMT+1", style = TextStyle(fontSize = 20.sp), color = Color.White)
                }
                "Temperature" -> {
                    Text(text = "20ºC", style = TextStyle(fontSize = 50.sp), color = Color.White)
                }
                "Condition" -> {
                    Text(text = "Cloudy", style = TextStyle(fontSize = 30.sp), color = Color.White)
                }
                "Hourly" -> {
                    HourlyForecastCard()
                }
                "Weekly" -> {
                    WeeklyForecastCard()
                }
            }
        })
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
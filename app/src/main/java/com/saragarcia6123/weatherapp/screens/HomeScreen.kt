package com.saragarcia6123.weatherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.saragarcia6123.weatherapp.ui.HourlyForecastCard
import com.saragarcia6123.weatherapp.ui.LocationBar
import com.saragarcia6123.weatherapp.ui.WeeklyForecastCard
import com.saragarcia6123.weatherapp.ui.theme.Secondary
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    modifier: Modifier = Modifier,
    scope: CoroutineScope
) {
    Column(
        modifier = modifier
            .background(Secondary)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LocationBar(onMenuItemClick = {
                scope.launch { scaffoldState.drawerState.open() }
        }, navController = navController)
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
                    Text(modifier = Modifier.padding(vertical = 8.dp), text = "13:48 GMT+1", style = TextStyle(fontSize = 20.sp), color = Color.White)
                }
                "Temperature" -> {
                    Text(text = "20ºC", style = TextStyle(fontSize = 60.sp), color = Color.White)
                }
                "Condition" -> {
                    Text(modifier = Modifier.padding(vertical = 8.dp), text = "Cloudy", style = TextStyle(fontSize = 30.sp), color = Color.White)
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
    HomeScreen(
        navController = rememberNavController(),
        scaffoldState = ScaffoldState(drawerState = DrawerState(DrawerValue.Open), snackbarHostState = SnackbarHostState()),
        scope = rememberCoroutineScope()
    )
}
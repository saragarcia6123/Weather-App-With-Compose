package com.saragarcia6123.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saragarcia6123.weatherapp.data.IconUtils
import com.saragarcia6123.weatherapp.ui.ThemeCard
import com.saragarcia6123.weatherapp.ui.theme.Accent
import com.saragarcia6123.weatherapp.ui.theme.Primary
import com.saragarcia6123.weatherapp.ui.theme.PrimaryDark
import com.saragarcia6123.weatherapp.ui.theme.Secondary
import com.saragarcia6123.weatherapp.ui.theme.WeatherAppTheme

class WeatherApp : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }

    @Composable
    fun Main() {
        Scaffold(
            bottomBar = { BottomNavigationBar() },
            content = { paddingValues ->  Content(modifier = Modifier.padding(paddingValues)) }
        )
    }

    @Composable
    fun Content(modifier: Modifier = Modifier) {
        HomePage()
    }

    @Composable
    fun TopBar(modifier: Modifier = Modifier) {
       Box()
         {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    tint = Primary,
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(42.dp)
                        .fillMaxSize()
                        .padding(end = 16.dp)
                )
                LocationBar()
                Spacer(
                    modifier = Modifier
                        .size(42.dp)
                        .padding(start = 16.dp)
                )
            }
        }
    }

    @Composable
    fun LocationBar(modifier: Modifier = Modifier) {
        Card {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .height(30.dp)
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = "Madrid, ES")
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Down arrow",
                        tint = Color.Gray,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }

    @Composable
    fun BottomNavigationBar(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(PrimaryDark)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            ) {
                IconButton(
                    onClick = {  }
                ) {
                    Image(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Maps",
                        colorFilter = ColorFilter.tint(color = Color.White),
                        modifier = Modifier
                            .size(35.dp)
                    )
                }
                IconButton(
                    onClick = {  }
                ) {
                    Image(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home",
                        colorFilter = ColorFilter.tint(color = Accent),
                        modifier = Modifier
                            .size(50.dp)
                    )
                }
                IconButton(
                    onClick = {  },
                ) {
                    Image(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        colorFilter = ColorFilter.tint(color = Color.White),
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun HomePage(modifier: Modifier = Modifier) {
        Column(
            modifier = Modifier
                .background(Secondary)
                .fillMaxSize()
        ) {
            TopBar()
            HomePageContent()
        }
    }

    @Composable
    fun HomePageContent(modifier: Modifier = Modifier) {
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
                        Text(text = "20ºC", style = TextStyle(fontSize = 50.sp), color = Color.White, modifier = Modifier.padding(top = 16.dp))
                    }
                    "Condition" -> {
                        Text(text = "Cloudy", style = TextStyle(fontSize = 30.sp), color = Color.White)
                    }
                    "Hourly" -> {
                        ThemeCard(
                            content = { HourlyForecastCard() },
                            backgroundColor = Secondary,
                            cardHeight = 120,
                            shadowBrush = defaultBoxGradient(),
                            modifier = Modifier
                                .padding(16.dp)
                        )
                    }
                    "Weekly" -> {
                        ThemeCard (
                            content = { WeeklyForecastCard() },
                            backgroundColor = Secondary,
                            cardHeight = 600,
                            shadowBrush = Brush.horizontalGradient(),
                            modifier = Modifier
                                .padding(16.dp)
                        )
                    }
                }
            })
        }
    }

    private fun defaultBoxGradient(): Brush {
        return Brush.horizontalGradient(listOf(Color.Transparent, Color.White))
    }

    @Composable
    fun HourlyForecastCard() {
        val list = IconUtils.getIconPainters()
        LazyRow(
            modifier = Modifier
                .padding(16.dp)
        ) {
            items(list) { icon ->
                Icon(painter = icon, contentDescription = null, modifier = Modifier.padding(8.dp))
            }
        }
    }

    @Composable
    fun WeeklyForecastCard() {

    }

    @Preview
    @Composable
    fun Preview() {
        Main()
    }

}
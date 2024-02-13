package com.saragarcia6123.weatherapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saragarcia6123.weatherapp.data.IconUtils
import com.saragarcia6123.weatherapp.domain.CurrentWeather
import com.saragarcia6123.weatherapp.domain.Location
import com.saragarcia6123.weatherapp.domain.WeatherCondition
import com.saragarcia6123.weatherapp.ui.theme.Secondary
import com.saragarcia6123.weatherapp.ui.theme.SecondaryDark

@Composable
fun HourlyForecastCard() {
    ThemeCard(
        content = { HourlyForecastContent(Location("London",0,0, null)) },
        backgroundColor = Color.White,
        cardHeight = 120,
        shadowBrush = Brush.horizontalGradient(listOf(Color.Transparent, Color.White)),
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
private fun HourlyForecastContent(location: Location, modifier: Modifier = Modifier) {
    val list = IconUtils.getIconPainters()
    LazyRow(
        modifier = modifier
            .padding(16.dp)
    ) {
        items(list) { icon ->
            Column {
                Icon(painter = icon,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 2.dp),
                    tint = SecondaryDark)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "20" + "º"
                    )
                }
                Text(text = "")
            }
        }
    }
}

@Preview
@Composable
private fun HourlyCardPreview() {
    HourlyForecastCard()
}

@Composable
fun WeeklyForecastCard() {
    ThemeCard (
        content = { WeeklyForecastContent(Location("London",0,0, null)) },
        backgroundColor = Secondary,
        cardHeight = 600,
        shadowBrush = Brush.horizontalGradient(listOf(Color.Transparent, Color.White)),
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
private fun WeeklyForecastContent(location: Location, modifier: Modifier = Modifier) {

    val weatherData = listOf(
        CurrentWeather(WeatherCondition.CLOUDY,
            temperature = 20,
            weatherIcon = IconUtils.getIconPainters()[0],
            timestamp = 10L
        )
    )

    Column(
        modifier = modifier.padding(horizontal = 8.dp)
    ) {
        weatherData.forEach {item ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "10:00",
                    fontSize = 24.sp
                )
                Icon(
                    painter = item.weatherIcon,
                    contentDescription = item.weatherDescription,
                    modifier = Modifier)
                Text(
                    text = item.temperature.toString() + "º",
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun WeeklyCardPreview() {
    WeeklyForecastCard()
}
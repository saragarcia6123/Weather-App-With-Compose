package com.saragarcia6123.weatherapp.domain

import androidx.compose.ui.graphics.painter.Painter

data class CurrentWeather(
    val weatherCondition: WeatherCondition, //enum
    val temperature: Int,
    val humidity: Int? = 0,
    val pressure: Double? = 0.0,
    val windSpeed: Double? = 0.0,
    val windDirection: Double? = 0.0,
    val weatherIcon: Painter,
    val timestamp: Long = 0,
    val sunriseTime: Long? = 0,
    val sunsetTime: Long? = 0
) {
    val weatherDescription: String = weatherCondition.name.uppercase()
}
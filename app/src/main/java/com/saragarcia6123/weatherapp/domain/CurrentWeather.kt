package com.saragarcia6123.weatherapp.domain

data class CurrentWeather(
    val weatherCondition: WeatherCondition, //enum
    val temperature: Double,
    val humidity: Int,
    val pressure: Double,
    val windSpeed: Double,
    val windDirection: Double,
    val weatherIcon: String,
    val timestamp: Long,
    val sunriseTime: Long,
    val sunsetTime: Long
) {
    val weatherDescription: String = weatherCondition.name.uppercase()
}


package com.saragarcia6123.weatherapp.domain

data class Location(
    val name: String,
    val latitude: Int,
    val longitude: Int,
    val currentWeather: CurrentWeather?
)
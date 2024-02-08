package com.saragarcia6123.weatherapp.domain

data class City(
    val name: String,
    val country: String,
    val latitude: Int,
    val longitude: Int,
    val currentWeather: CurrentWeather?
)
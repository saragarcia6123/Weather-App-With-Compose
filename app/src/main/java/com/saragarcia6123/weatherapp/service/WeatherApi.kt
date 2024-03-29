package com.saragarcia6123.weatherapp.service

data class LocationData(
    val current: Current,
    val location: Location
)

data class Location(
    val country: String,
    val lat: Double,
    val localtime: String,
    val localtime_epoch: Int,
    val lon: Double,
    val name: String,
    val region: String,
    val tz_id: String
)

data class Current(
    val cloud: Int,
    val condition: Condition,
    val feelslike_c: Int,
    val feelslike_f: Double,
    val gust_kph: Double,
    val gust_mph: Double,
    val humidity: Int,
    val is_day: Int,
    val last_updated: String,
    val last_updated_epoch: Int,
    val precip_in: Int,
    val precip_mm: Int,
    val pressure_in: Double,
    val pressure_mb: Int,
    val temp_c: Int,
    val temp_f: Int,
    val uv: Int,
    val vis_km: Int,
    val vis_miles: Int,
    val wind_degree: Int,
    val wind_dir: String,
    val wind_kph: Int,
    val wind_mph: Double
)

data class Condition(
    val code: Int,
    val icon: String,
    val text: String
)
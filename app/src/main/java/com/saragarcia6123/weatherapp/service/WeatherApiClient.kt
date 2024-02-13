package com.saragarcia6123.weatherapp.service

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.io.InputStream
import java.util.Properties

@Composable
fun getBaseUrl(): String {
    return "https://api.weatherapi.com/v1/current.json?"
}
@Composable
private fun readApiKey(): String {
    val context = LocalContext.current
    val inputStream: InputStream = context.assets.open("secrets.properties")
    val properties = Properties()
    properties.load(inputStream)
    return properties.getProperty("weather_api_key") ?: ""
}

interface ApiService {
    @GET("&q")
    suspend fun getLocation(@Query("key") key: String): Response<List<LocationData>>
}

@Preview
@Composable
fun ApiData() {
    Text(text = "")
}
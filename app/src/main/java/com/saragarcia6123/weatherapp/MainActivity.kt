package com.saragarcia6123.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.saragarcia6123.weatherapp.ui.theme.WeatherAppTheme

class WeatherApp : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        setContent {
            WeatherAppTheme {
                MainScreen()
            }
        }
    }

    @Preview
    @Composable
    fun AppPreview() {
        WeatherAppTheme {
            MainScreen()
        }
    }

}
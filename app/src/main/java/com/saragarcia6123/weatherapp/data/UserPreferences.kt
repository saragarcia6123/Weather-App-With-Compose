package com.saragarcia6123.weatherapp.data

import android.content.Context
import android.content.SharedPreferences

interface UserPreferencesDataSource {
    fun getString(key: String, defaultValue: String): String
    fun putString(key: String, value: String)
}

class SharedPreferencesUserPreferencesDataSource(context: Context) : UserPreferencesDataSource {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

    override fun getString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    override fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

}

class UserRepository(private val userPreferencesDataSource: UserPreferencesDataSource) {

    fun unitPreference(): String {
        return userPreferencesDataSource.getString("unit_preference", defaultValue = "c")
    }

    fun setUnitPreferenceToCelsius() { userPreferencesDataSource.putString("unit_preference", "c") }
    fun setUnitPreferenceToFahrenheit() { userPreferencesDataSource.putString("unit_preference", "f") }

}

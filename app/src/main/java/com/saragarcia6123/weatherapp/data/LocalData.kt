package com.saragarcia6123.weatherapp.data

import androidx.lifecycle.ViewModel
import com.saragarcia6123.weatherapp.domain.Location

class LocalData: ViewModel() {

    var savedLocations: List<Location> = emptyList()

    companion object {
        @Volatile
        private var instance: LocalData? = null

        fun getInstance(): LocalData {
            return instance ?: synchronized(this) {
                instance ?: LocalData().also { instance = it }
            }
        }
    }

}

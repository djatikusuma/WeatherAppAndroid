package com.codekinian.weatherapp.data.store.current

import com.codekinian.weatherapp.data.model.current.CurrentResponse

interface CurrentDataStore {
    suspend fun getCurrentData(city: String): CurrentResponse?
    suspend fun saveData(city: String, currentResponse: CurrentResponse)
}

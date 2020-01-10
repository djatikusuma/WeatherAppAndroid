package com.codekinian.weatherapp.data.store.daily

import com.codekinian.weatherapp.data.model.daily.DailyResponse

interface DailyDataStore {
    suspend fun getForecastData(city: String): DailyResponse?
    suspend fun saveData(city: String, dailyResponse: DailyResponse)
}
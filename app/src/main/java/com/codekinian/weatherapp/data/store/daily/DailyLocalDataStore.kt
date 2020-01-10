package com.codekinian.weatherapp.data.store.daily

import com.codekinian.weatherapp.data.model.daily.DailyResponse

class DailyLocalDataStore : DailyDataStore {
    private val caches = mutableMapOf<String, DailyResponse?>()
    override suspend fun getForecastData(city: String): DailyResponse? =
        if (caches.contains(city)) caches[city] else null

    override suspend fun saveData(city: String, dailyResponse: DailyResponse) {
        caches[city] = dailyResponse
    }


}
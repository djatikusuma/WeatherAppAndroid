package com.codekinian.weatherapp.repository

import com.codekinian.weatherapp.base.BaseRepository
import com.codekinian.weatherapp.data.model.daily.DailyResponse
import com.codekinian.weatherapp.data.store.daily.DailyDataStore

class DailyWeatherRepository private constructor() : BaseRepository<DailyDataStore>() {
    suspend fun getForecastData(city: String): DailyResponse? {
        val cache = localDataStore?.getForecastData(city)
        if (cache != null) return cache
        val response = remoteDataStore?.getForecastData(city)
        localDataStore?.saveData(city, response!!)
        return response
    }

    companion object {
        val instance by lazy { DailyWeatherRepository() }
    }
}
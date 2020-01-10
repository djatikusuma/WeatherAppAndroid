package com.codekinian.weatherapp.repository

import com.codekinian.weatherapp.base.BaseRepository
import com.codekinian.weatherapp.data.model.current.CurrentResponse
import com.codekinian.weatherapp.data.store.current.CurrentDataStore

class CurrentWeatherRepository private constructor() : BaseRepository<CurrentDataStore>() {
    suspend fun getCurrentWeather(city: String): CurrentResponse? {
        val cache = localDataStore?.getCurrentData(city)
        if (cache != null) return cache
        val response = remoteDataStore?.getCurrentData(city)
        localDataStore?.saveData(city, response!!)
        return response
    }

    companion object {
        val instance by lazy { CurrentWeatherRepository() }
    }
}
package com.codekinian.weatherapp.repository

import com.codekinian.weatherapp.base.BaseRepository
import com.codekinian.weatherapp.data.model.current.CurrentResponse
import com.codekinian.weatherapp.data.store.current.CurrentDataStore

class CurrentWheaterRepository private constructor() : BaseRepository<CurrentDataStore>() {
    suspend fun getCurrentWeather(postalCode: String): CurrentResponse? {
        val cache = localDataStore?.getCurrentData(postalCode)
        if (cache != null) return cache
        val response = remoteDataStore?.getCurrentData(postalCode)
        localDataStore?.saveData(postalCode, response!!)
        return response
    }

    companion object {
        val instance by lazy { CurrentWheaterRepository() }
    }
}
package com.codekinian.weatherapp.data.store.daily

import com.codekinian.weatherapp.BuildConfig
import com.codekinian.weatherapp.base.BaseRoute
import com.codekinian.weatherapp.data.model.daily.DailyResponse

class DailyRemoteDataStore(private val api: BaseRoute) : DailyDataStore {
    override suspend fun getForecastData(city: String): DailyResponse? {
        val response = api.getForecastWeather(city, 5, BuildConfig.API_KEY)
        if (response.isSuccessful) return response.body()

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun saveData(city: String, dailyResponse: DailyResponse) {

    }

}
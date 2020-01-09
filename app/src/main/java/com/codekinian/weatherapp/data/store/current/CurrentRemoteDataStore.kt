package com.codekinian.weatherapp.data.store.current

import com.codekinian.weatherapp.BuildConfig.API_KEY
import com.codekinian.weatherapp.base.BaseRoute
import com.codekinian.weatherapp.data.model.current.CurrentResponse

class CurrentRemoteDataStore(private val api: BaseRoute) : CurrentDataStore {
    override suspend fun getCurrentData(city: String): CurrentResponse? {
        val response = api.getCurrentWheater(city, API_KEY)
        if (response.isSuccessful) return response.body()

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun saveData(city: String, currentResponse: CurrentResponse) {

    }

}
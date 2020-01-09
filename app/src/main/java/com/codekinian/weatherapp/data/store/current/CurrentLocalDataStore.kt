package com.codekinian.weatherapp.data.store.current

import com.codekinian.weatherapp.data.model.current.CurrentResponse

class CurrentLocalDataStore : CurrentDataStore {
    private val caches = mutableMapOf<String, CurrentResponse?>()
    override suspend fun getCurrentData(city: String): CurrentResponse? =
        if (caches.contains(city)) caches[city] else null

    override suspend fun saveData(city: String, currentResponse: CurrentResponse) {
        caches[city] = currentResponse
    }


}
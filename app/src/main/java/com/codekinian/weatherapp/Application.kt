package com.codekinian.weatherapp

import android.app.Application
import com.codekinian.weatherapp.base.BaseApiService
import com.codekinian.weatherapp.data.store.current.CurrentLocalDataStore
import com.codekinian.weatherapp.data.store.current.CurrentRemoteDataStore
import com.codekinian.weatherapp.repository.CurrentWheaterRepository

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        val api = BaseApiService.api
        CurrentWheaterRepository.instance.apply {
            init(CurrentLocalDataStore(), CurrentRemoteDataStore(api))
        }
    }
}
package com.codekinian.weatherapp

import android.app.Application
import com.codekinian.weatherapp.base.BaseApiService
import com.codekinian.weatherapp.data.store.current.CurrentLocalDataStore
import com.codekinian.weatherapp.data.store.current.CurrentRemoteDataStore
import com.codekinian.weatherapp.data.store.daily.DailyLocalDataStore
import com.codekinian.weatherapp.data.store.daily.DailyRemoteDataStore
import com.codekinian.weatherapp.repository.CurrentWeatherRepository
import com.codekinian.weatherapp.repository.DailyWeatherRepository

class Application : Application() {
    override fun onCreate() {
        super.onCreate()

        val api = BaseApiService.api
        CurrentWeatherRepository.instance.apply {
            init(CurrentLocalDataStore(), CurrentRemoteDataStore(api))
        }
        DailyWeatherRepository.instance.apply {
            init(DailyLocalDataStore(), DailyRemoteDataStore(api))
        }
    }
}
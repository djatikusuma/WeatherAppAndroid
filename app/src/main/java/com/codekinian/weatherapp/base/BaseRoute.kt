package com.codekinian.weatherapp.base

import com.codekinian.weatherapp.data.model.current.CurrentResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseRoute {
    @GET("weather")
    suspend fun getCurrentWheater(@Query("q") q: String, @Query("appid") appid: String): Response<CurrentResponse>
}
package com.codekinian.weatherapp.data.model.daily


import com.codekinian.weatherapp.data.model.current.Weather
import com.google.gson.annotations.SerializedName

data class ListClouds(
    @SerializedName("clouds")
    val clouds: Int? = null,
    @SerializedName("deg")
    val deg: Int? = null,
    @SerializedName("dt")
    val dt: Int? = null,
    @SerializedName("feels_like")
    val feelsLike: FeelsLike? = null,
    @SerializedName("humidity")
    val humidity: Int? = null,
    @SerializedName("pressure")
    val pressure: Int? = null,
    @SerializedName("rain")
    val rain: Double? = null,
    @SerializedName("speed")
    val speed: Double? = null,
    @SerializedName("sunrise")
    val sunrise: Int? = null,
    @SerializedName("sunset")
    val sunset: Int? = null,
    @SerializedName("temp")
    val temp: Temp? = null,
    @SerializedName("weather")
    val weather: List<Weather?>? = null
)
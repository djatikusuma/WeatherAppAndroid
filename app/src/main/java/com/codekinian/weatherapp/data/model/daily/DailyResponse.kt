package com.codekinian.weatherapp.data.model.daily


import com.google.gson.annotations.SerializedName

data class DailyResponse(
    @SerializedName("city")
    val city: City? = null,
    @SerializedName("cnt")
    val cnt: Int? = null,
    @SerializedName("cod")
    val cod: String? = null,
    @SerializedName("list")
    val list: List<ListClouds?>? = null,
    @SerializedName("message")
    val message: Double? = null
)
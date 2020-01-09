package com.codekinian.weatherapp.data.model.current


import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("1h")
    val h: Double? = null
)
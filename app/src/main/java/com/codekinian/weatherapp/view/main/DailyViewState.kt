package com.codekinian.weatherapp.view.main

import com.codekinian.weatherapp.data.model.daily.DailyResponse

data class DailyViewState(
    var loading: Boolean = true,
    var error: Exception? = null,
    var data: DailyResponse? = null
)
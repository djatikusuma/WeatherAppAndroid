package com.codekinian.weatherapp.view.main

import com.codekinian.weatherapp.data.model.current.CurrentResponse

data class MainViewState(
    var loading: Boolean = true,
    var error: Exception? = null,
    var data: CurrentResponse? = null
)
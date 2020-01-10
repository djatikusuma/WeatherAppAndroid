package com.codekinian.weatherapp.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codekinian.weatherapp.repository.CurrentWeatherRepository
import com.codekinian.weatherapp.repository.DailyWeatherRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val mViewState = MutableLiveData<MainViewState>().apply {
        value = MainViewState(loading = true)
    }
    private val dViewState = MutableLiveData<DailyViewState>().apply {
        value = DailyViewState(loading = true)
    }

    val viewState: LiveData<MainViewState>
        get() = mViewState
    val dailyData: LiveData<DailyViewState>
        get() = dViewState

    fun fetchData(city: String) = viewModelScope.launch {
        try {
            val data = CurrentWeatherRepository.instance.getCurrentWeather(city)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, data = null)
        }
    }

    fun fetchForecast(city: String) = viewModelScope.launch {
        try {
            val data = DailyWeatherRepository.instance.getForecastData(city)
            dViewState.value = dViewState.value?.copy(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            dViewState.value = dViewState.value?.copy(loading = false, error = ex, data = null)
        }
    }
}
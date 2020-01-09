package com.codekinian.weatherapp.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codekinian.weatherapp.repository.CurrentWheaterRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: CurrentWheaterRepository
) : ViewModel() {
    private val mViewState = MutableLiveData<MainViewState>().apply {
        value = MainViewState(loading = true)
    }

    val viewState: LiveData<MainViewState>
        get() = mViewState

    fun fetchData(city: String) = viewModelScope.launch {
        try {
            val data = repository.getCurrentWeather(city)
            mViewState.value = mViewState.value?.copy(loading = false, error = null, data = data)
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(loading = false, error = ex, data = null)
        }
    }
}
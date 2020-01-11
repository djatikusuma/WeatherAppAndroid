package com.codekinian.weatherapp.view.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class LoginViewModel(
    private val listener: LoginCallback
) : ViewModel() {
    var userName: ObservableField<String> = ObservableField()
    var userCity: ObservableField<String> = ObservableField()

    fun onNextButton() {
        if (userName.get().isNullOrEmpty() && userCity.get().isNullOrEmpty()) {
            listener.onFailure("Nama lengkap atau Kota tidak boleh kosong")
        } else {
            listener.onSuccess(userName.get().toString(), userCity.get().toString())
        }
    }
}
package com.codekinian.weatherapp.view.login

interface LoginCallback {
    fun onSuccess(userName: String, userCity: String)
    fun onFailure(message: String)
}
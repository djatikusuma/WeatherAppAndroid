package com.codekinian.weatherapp.base

import com.codekinian.weatherapp.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class BaseApiService {
    companion object {
        private fun interceptor(): OkHttpClient {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()
        }

        private fun client(): Retrofit {
            return Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .client(interceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: BaseRoute = client().create(BaseRoute::class.java)
    }
}
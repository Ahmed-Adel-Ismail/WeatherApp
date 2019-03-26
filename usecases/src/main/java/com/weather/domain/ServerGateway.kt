package com.weather.domain

import com.weather.entities.ForecastsResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val SERVER_BASE_URL = "http://api.openweathermap.org/"
private const val APP_ID_KEY = "appid"
private const val APP_ID_VALUE = "cc8bf0ef9fefd3794a362f69e9b0721d"


private val retrofit: Retrofit by lazy {
    Retrofit.Builder()
        .baseUrl(SERVER_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

val forecastsApis: ForecastsApis by lazy {
    retrofit.create(ForecastsApis::class.java)
}


interface ForecastsApis {

    @GET("data/2.5/forecast")
    fun requestFiveDaysForecast(
        @Query("id") cityId: String,
        @Query(APP_ID_KEY) appId: String = APP_ID_VALUE
    ): Single<ForecastsResponse>
}



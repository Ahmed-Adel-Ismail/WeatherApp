package com.weather.domain

import com.weather.entities.ForecastsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


private const val SERVER_BASE_URL = "api.openweathermap.org/"

interface ServerApis {

    @GET("data/2.5/forecast")
    fun requestFiveDaysForecast(@Query("id") cityId: String): Observable<ForecastsResponse>


}
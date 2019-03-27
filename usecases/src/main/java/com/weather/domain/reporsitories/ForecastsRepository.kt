package com.weather.domain.reporsitories

import com.weather.domain.ForecastsApis
import com.weather.domain.forecastsApis
import com.weather.entities.ForecastsResponse
import io.reactivex.Single

val forecastsRepository: ForecastsRepository by lazy { ForecastRepositoryImplementer() }

interface ForecastsRepository {

    fun requestFiveDaysForecast(cityId: String): Single<ForecastsResponse>
}


class ForecastRepositoryImplementer(
    private val server: ForecastsApis = forecastsApis
) : ForecastsRepository {

    override fun requestFiveDaysForecast(cityId: String) = server.requestFiveDaysForecast(cityId)

}
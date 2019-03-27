package com.weather.domain.usecases

import com.weather.domain.ForecastsApis
import com.weather.domain.reporsitories.ForecastsRepository
import com.weather.domain.reporsitories.forecastsRepository

class ShowCityForecastUseCase(
    private val repository: ForecastsRepository = forecastsRepository
) {

    operator fun invoke(cityId: Long) =
        repository.requestFiveDaysForecast(cityId.toString())


}
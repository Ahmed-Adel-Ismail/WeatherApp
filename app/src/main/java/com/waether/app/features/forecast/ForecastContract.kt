package com.waether.app.features.forecast

import com.weather.entities.City
import com.weather.entities.Forecast

interface ForecastView {
    fun drawCityTitle(cityTitle: String)
    fun startLoading()
    fun stopLoading()
    fun drawForcastList(forcasts: List<Forecast>)
    fun drawAsFavoriteCity()
    fun drawAsNotFavoriteCity()
}

interface ForecastPresenter {
    fun initializeView(city: City)
    fun addCityToFavoritesClicked()
    fun removeCityFromFavorites()
}


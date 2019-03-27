package com.waether.app.features.forecast

import android.arch.lifecycle.DefaultLifecycleObserver
import android.arch.lifecycle.LifecycleObserver
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

interface ForecastPresenter : DefaultLifecycleObserver {
    fun initializeCity(city: City)
    fun addCityToFavoritesClicked()
    fun removeCityFromFavorites()
}


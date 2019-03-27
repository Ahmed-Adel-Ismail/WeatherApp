package com.waether.app.features.forecast

import com.weather.entities.City

class ForecastPresenterImplementer(private val view: ForecastView) : ForecastPresenter {

    override fun initializeView(city: City) {
    }

    override fun addCityToFavoritesClicked() {
    }

    override fun removeCityFromFavorites() {
    }
}
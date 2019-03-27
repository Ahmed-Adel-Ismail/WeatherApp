package com.waether.app.features.forecast

import com.weather.entities.City
import com.weather.entities.Forecast
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class ForecastPresenterImplementerTest{


    @Test
    fun `initializeView then startLoading`(){
        var result = false
        val view = object : ForecastView{
            override fun drawCityTitle(cityTitle: String) {
            }

            override fun startLoading() {
                result = true
            }

            override fun stopLoading() {
            }

            override fun drawForcastList(forcasts: List<Forecast>) {
            }

            override fun drawAsFavoriteCity() {
            }

            override fun drawAsNotFavoriteCity() {
            }
        }

        val presenter = ForecastPresenterImplementer(view)

        // Act
        presenter.initializeView(City(0,"","",null))

        // Assert
        Assert.assertTrue(result)

    }

}
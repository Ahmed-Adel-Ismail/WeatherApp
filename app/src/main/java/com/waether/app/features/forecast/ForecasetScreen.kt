package com.waether.app.features.forecast

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.waether.app.R
import com.waether.app.core.ContentViewId
import com.waether.app.features.home.EXTRA_CITY
import com.weather.entities.City
import com.weather.entities.Forecast
import kotlinx.android.synthetic.main.activity_main.*

@ContentViewId(R.layout.activity_main)
class ForecastActivity : AppCompatActivity(), ForecastView {

    private val presenter: ForecastPresenter by lazy {
        ForecastPresenterImplementer(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val city = intent.getSerializableExtra(EXTRA_CITY) as City
        presenter.initializeCity(city)
        lifecycle.addObserver(presenter)




        add_to_favorites_button.setOnClickListener {
            if (it.isSelected) {
                presenter.removeCityFromFavorites()
            } else {
                presenter.addCityToFavoritesClicked()
            }
        }

    }

    override fun startLoading() {
//        progress.visibility = VISIBLE
    }

    override fun stopLoading() {
//        progress.visibility = GONE
    }

    override fun drawForcastList(forcasts: List<Forecast>) {
//        recyclerView.adapter = ForcastAdapter(forcasts)
    }

    override fun drawCityTitle(cityTitle: String) {

    }

    override fun drawAsFavoriteCity() {
        add_to_favorites_button.isSelected = true
    }

    override fun drawAsNotFavoriteCity() {
        add_to_favorites_button.isSelected = false
    }
}




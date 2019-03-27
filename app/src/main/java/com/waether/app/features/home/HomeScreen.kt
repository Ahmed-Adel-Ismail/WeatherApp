package com.waether.app.features.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.waether.app.R
import com.waether.app.core.ContentViewId
import com.waether.app.features.forecast.ForecastActivity
import com.weather.entities.City
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_home.*
import java.io.Serializable
import java.util.concurrent.TimeUnit

@ContentViewId(R.layout.fragment_home)
class HomeActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(HomeViewModel::class.java) }
    private val disposables = CompositeDisposable()

    private val showButtonReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            viewModel.showCityForecast.onNext(intent!!.getSerializableExtra(EXTRA_CITY))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getProgressLiveData().observe(this, Observer {
            search_progress_bar.visibility = if (it!!) View.VISIBLE else View.GONE
        })

        viewModel.showCityForecast
            .debounce(500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { startForecastScreen(it) }
            .also { disposables.add(it) }

        search_button.setOnClickListener {
            viewModel.onSearchButtonClicked(search_edit_text.text?.toString())
        }


        results_recycler_view.layoutManager = LinearLayoutManager(this)
        results_recycler_view.adapter = CitySearchResultsAdapter(this, viewModel.citiesResult)

        registerReceiver(showButtonReceiver, IntentFilter(ACTION_SHOW_CITY_BUTTON_CLICKED))
    }

    private fun startForecastScreen(citySerializable: Serializable) {
        Intent(this@HomeActivity, ForecastActivity::class.java)
            .putExtra(EXTRA_CITY, citySerializable)
            .also { startActivity(it) }
    }

    override fun onDestroy() {
        unregisterReceiver(showButtonReceiver)
        disposables.dispose()
        super.onDestroy()
    }
}



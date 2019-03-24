package com.waether.app.features.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.weather.entities.City
import com.weather.domain.usecases.CitiesResult
import com.weather.domain.usecases.SearchCityByNameUseCase
import com.weather.domain.engine.toMutableLiveData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    val searchProgress: MutableLiveData<Boolean> = false.toMutableLiveData(),
    val citiesResult: CitiesResult = ArrayList<City>().toMutableLiveData(),
    private val searchCityByName: SearchCityByNameUseCase = SearchCityByNameUseCase(
        searchProgress,
        citiesResult
    )
) : ViewModel() {


    fun onSearchButtonClicked(cityName: String?) {
        Observable.fromCallable { searchCityByName(cityName) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    override fun onCleared() {
        super.onCleared()
    }
}
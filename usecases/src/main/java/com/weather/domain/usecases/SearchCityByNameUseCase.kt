package com.weather.domain.usecases

import android.arch.lifecycle.MutableLiveData
import com.weather.entities.City
import com.weather.domain.reporsitories.CitiesRepository
import com.weather.domain.reporsitories.citiesRepository

typealias CitiesResult = MutableLiveData<List<City>>

class SearchCityByNameUseCase(
    private val searching: MutableLiveData<Boolean>,
    private val result: CitiesResult,
    private val repository: CitiesRepository = citiesRepository
) {
    operator fun invoke(cityName: String?) {
        cityName
            ?.takeUnless { searching.value ?: false }
            ?.takeUnless { it.isBlank() }
            ?.also { searching.postValue(true) }
            ?.let { repository.searchCitiesByName(it) }
            ?.also { result.postValue(it) }
            ?.also { searching.postValue(false) }
    }

}
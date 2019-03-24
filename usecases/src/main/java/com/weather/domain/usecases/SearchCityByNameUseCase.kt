package com.weather.domain.usecases

import android.arch.lifecycle.MutableLiveData
import com.weather.entities.City
import com.weather.domain.reporsitories.CitiesRepository
import com.weather.domain.reporsitories.citiesRepository

// usecase 1 : search city by name
// if is searching, then do not trigger action
// city name must not be null
// if all is OK, trigger search

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
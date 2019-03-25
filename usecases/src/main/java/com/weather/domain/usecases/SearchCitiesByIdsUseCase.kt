package com.weather.domain.usecases

import android.arch.lifecycle.MutableLiveData
import com.weather.domain.reporsitories.CitiesRepository
import com.weather.domain.reporsitories.citiesRepository
import com.weather.entities.City


class SearchCitiesByIdsUseCase(
    private val resultLiveData: MutableLiveData<List<City>>,
    private val searching: MutableLiveData<Boolean>,
    private val repository: CitiesRepository = citiesRepository
) {

    operator fun invoke(citiesIds: List<Long>) {
        citiesIds.takeUnless { searching.value ?: false }
            ?.also { searching.postValue(true) }
            ?.let { repository.retrieveCitiesByIds(it) }
            ?.also { resultLiveData.postValue(it) }
            ?.also { searching.postValue(false) }
    }


}
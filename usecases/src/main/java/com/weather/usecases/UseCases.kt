package com.weather.usecases

import android.arch.lifecycle.MutableLiveData
import com.weather.entities.City
import com.weather.usecases.reporsitories.CitiesRepository
import com.weather.usecases.reporsitories.citiesRepository

fun numberIncrementer(liveData: MutableLiveData<Int>, incrementBy: Int = 1) {
    val oldValue = liveData.value ?: 0
    liveData.postValue(oldValue + incrementBy)
}

// usecase 1 : search city by name
// if is searching, then do not trigger action
// city name must not be null
// if all is OK, trigger search


fun retrieveCitiesByName(
    searchName: String?,
    retrieving: MutableLiveData<Boolean>,
    result: MutableLiveData<List<City>>,
    repository: CitiesRepository = citiesRepository
) {

    searchName
        ?.takeUnless { retrieving.value ?: false }
        ?.takeUnless { it.isBlank() }
        ?.also { retrieving.postValue(true) }
        ?.let { repository.searchCitiesByName(it) }
        ?.also { result.postValue(it) }
        ?.also { retrieving.postValue(false) }

}


// usecase 2 : retrieve favorite cities ids (longs)
// if is retrieving, then do not trigger action
// if favorites is empty, throw an exception
// if favorites not empty, convert them to ids (longs)




// usecase 3 : retrieve cities by Ids
// if is retrieving, then do not trigger action
// if all is Ok, trigger action


fun retrieveCitiesByIds(
    ids: List<Long>,
    retrieving: MutableLiveData<Boolean>,
    result: MutableLiveData<List<City>>,
    repository: CitiesRepository = citiesRepository
) {

    ids.takeUnless { retrieving.value ?: false }
        ?.also { retrieving.postValue(true) }
        ?.let { repository.retrieveCitiesByIds(it) }
        ?.also { result.postValue(it) }
        ?.also { retrieving.postValue(false) }
}

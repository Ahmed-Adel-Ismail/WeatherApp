package com.weather.domain.usecases

import android.arch.lifecycle.MutableLiveData
import com.weather.domain.reporsitories.CitiesRepository
import com.weather.domain.reporsitories.citiesRepository
import com.weather.entities.City
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import java.lang.UnsupportedOperationException


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

class RxSearchCitiesByIdsUseCase(
    private val searching: MutableLiveData<Boolean>,
    private val repository: CitiesRepository = citiesRepository
) {
    operator fun invoke(citiesIds: List<Long>) {

        val subject = BehaviorSubject.createDefault(listOf<Int>())

        val list = listOf(1, 2, 3, 4)
        subject
            .filter { /* filter by cityName */ true}
            .subscribe({ /* draw on UI */}, {}, { System.out.print("completed") })


        val response = listOf(1,2,3,4)
        subject.onNext(response)

        val response2 = response + listOf(5,6,7,8)
        subject.onNext(response2)


    }


}


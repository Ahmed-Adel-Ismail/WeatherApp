package com.weather.domain.usecases

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import com.weather.domain.fakeCitiesList
import com.weather.domain.reporsitories.CitiesRepository
import com.weather.domain.reporsitories.CitiesRepositoryMock
import com.weather.entities.City
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

// usecase 3 : retrieve cities by Ids
// if is retrieving, then do not trigger action
// if all is Ok, trigger action


class SearchCitiesByIdsUseCaseTest {

    @JvmField
    @Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    // if all is Ok, trigger action
    @Test
    fun `invoke with successful response then update resultLiveData value`(){

        // Arrange
        val citiesIds = listOf(1L,2L,3L)
        val resultLiveData = MutableLiveData<List<City>>()
        val repository : CitiesRepository = CitiesRepositoryForSearchCitiesById()
        val searching = MutableLiveData<Boolean>()
        val searchCitiesByIdsUseCase = SearchCitiesByIdsUseCase(resultLiveData,searching,repository)

        // Act
        searchCitiesByIdsUseCase(citiesIds)

        // Assert
        Assert.assertTrue(resultLiveData.value!!.isNotEmpty())
    }

    // if is already searching, then do not trigger action
    @Test
    fun `invoke while searching then do not update resultLiveData`(){

        // Arrange
        val citiesIds = listOf(1L,2L,3L)
        val resultLiveData = MutableLiveData<List<City>>()
        val searching = MutableLiveData<Boolean>()
        val repository : CitiesRepository = CitiesRepositoryForSearchCitiesById()
        val searchCitiesByIdsUseCase = SearchCitiesByIdsUseCase(resultLiveData,searching,repository)

        // Act
        searching.value = true
        searchCitiesByIdsUseCase(citiesIds)

        //Assert
        Assert.assertTrue(resultLiveData.value == null)
    }

}


class CitiesRepositoryForSearchCitiesById : CitiesRepositoryMock(){
    override fun retrieveCitiesByIds(citiesIds: List<Long>): List<City> {
        return fakeCitiesList
    }
}
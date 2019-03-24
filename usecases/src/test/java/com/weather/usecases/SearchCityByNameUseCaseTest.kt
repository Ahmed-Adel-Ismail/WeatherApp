package com.weather.usecases

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import com.weather.entities.City
import com.weather.usecases.engine.toMutableLiveData
import com.weather.usecases.reporsitories.CitiesRepositoryMock
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class SearchCityByNameUseCaseTest{

    @JvmField
    @Rule
    val instantExecutorRule = InstantTaskExecutorRule()

// usecase 1 : search city by name
// if is searching, then do not trigger action
// city name must not be null
// if all is OK, trigger search

    // if all is OK, trigger search
    @Test
    fun `invoke with successful response then update result`(){

        // Arrange
        val searching = MutableLiveData<Boolean>()
        val cityName = "any name"
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCityByName()
        val searchCityByNameUseCase = SearchCityByNameUseCase(searching,result, repository)

        // Act
        searchCityByNameUseCase.invoke(cityName)

        // Assert
        Assert.assertTrue(result.value!!.isNotEmpty())

    }

    // city name must not be null
    @Test
    fun `invoke with null cityName then do not update result`(){

        // Arrange
        val searching = MutableLiveData<Boolean>()
        val cityName: String? = null
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCityByName()
        val searchCityByNameUseCase = SearchCityByNameUseCase(searching,result, repository)

        // Act
        searchCityByNameUseCase.invoke(cityName)


        // Assert
        Assert.assertTrue(result.value == null)

    }


    // if is searching, then do not trigger action
    @Test
    fun `invoke with searching as true then do not update result`(){

        // Arrange
        val searching = true.toMutableLiveData()
        val cityName: String = "any name"
        val result = MutableLiveData<List<City>>()
        val repository = CitiesRepositoryForSearchCityByName()
        val searchCityByNameUseCase = SearchCityByNameUseCase(searching,result, repository)

        // Act
        searchCityByNameUseCase.invoke(cityName)


        // Assert
        Assert.assertTrue(result.value == null)

    }

}

class CitiesRepositoryForSearchCityByName : CitiesRepositoryMock(){

    val result = listOf(City(0L,"","",null),City(0L,"","",null))

    override fun searchCitiesByName(name: String): List<City> {
        return result
    }
}
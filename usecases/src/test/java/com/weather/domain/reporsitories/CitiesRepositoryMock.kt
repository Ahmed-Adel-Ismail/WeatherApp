package com.weather.domain.reporsitories

import com.weather.entities.City
import com.weather.entities.FavoriteCityId

open class CitiesRepositoryMock : CitiesRepository {

    override fun searchCitiesByName(name: String): List<City> {
        return listOf()
    }

    override fun retrieveFavoriteCitiesIds(): List<FavoriteCityId> {
        return listOf()
    }

    override fun retrieveCitiesByIds(citiesIds: List<Long>): List<City> {
        return listOf()
    }

    override fun addFavoriteCityId(favoriteCityId: FavoriteCityId) {
    }

    override fun removeFavoriteCityId(favoriteCityId: FavoriteCityId) {
    }
}
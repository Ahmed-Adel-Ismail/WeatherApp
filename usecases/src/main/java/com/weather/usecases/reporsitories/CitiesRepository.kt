package com.weather.usecases.reporsitories

import com.weather.entities.FavoriteCityId
import com.weather.usecases.database.WeatherDatabase
import com.weather.usecases.database.weatherDatabase

val citiesRepository by lazy { CitiesRepository() }

class CitiesRepository(private val database: WeatherDatabase = weatherDatabase) {

    fun searchCitiesByName(name: String) = database.citiesDao.queryCitiesByName(name)

    fun retrieveFavoriteCitiesIds() = database.favoritesDao.queryAll()

    fun retrieveCitiesByIds(citiesIds: List<Long>) = database.citiesDao.queryCitiesByIds(citiesIds)

    fun addFavoriteCityId(favoriteCityId: FavoriteCityId) = database.favoritesDao.insert(favoriteCityId)

    fun removeFavoriteCityId(favoriteCityId: FavoriteCityId) = database.favoritesDao.delete(favoriteCityId)

}
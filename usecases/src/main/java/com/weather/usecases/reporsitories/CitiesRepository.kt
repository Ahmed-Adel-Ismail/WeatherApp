package com.weather.usecases.reporsitories

import com.weather.entities.City
import com.weather.entities.FavoriteCityId
import com.weather.usecases.database.WeatherDatabase
import com.weather.usecases.database.weatherDatabase

val citiesRepository: CitiesRepository by lazy { CitiesRepositoryImplementer() }

interface CitiesRepository {

    fun searchCitiesByName(name: String): List<City>

    fun retrieveFavoriteCitiesIds(): List<FavoriteCityId>

    fun retrieveCitiesByIds(citiesIds: List<Long>): List<City>

    fun addFavoriteCityId(favoriteCityId: FavoriteCityId): Unit

    fun removeFavoriteCityId(favoriteCityId: FavoriteCityId): Unit
}

class CitiesRepositoryImplementer(private val database: WeatherDatabase = weatherDatabase) : CitiesRepository {

    override fun searchCitiesByName(name: String) = database.citiesDao.queryCitiesByName(name)

    override fun retrieveFavoriteCitiesIds() = database.favoritesDao.queryAll()

    override fun retrieveCitiesByIds(citiesIds: List<Long>) = database.citiesDao.queryCitiesByIds(citiesIds)

    override fun addFavoriteCityId(favoriteCityId: FavoriteCityId) = database.favoritesDao.insert(favoriteCityId)

    override fun removeFavoriteCityId(favoriteCityId: FavoriteCityId) = database.favoritesDao.delete(favoriteCityId)

}
package com.weather.usecases.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.weather.entities.City
import com.weather.entities.FavoriteCityId
import com.weather.usecases.applicationLiveData
import com.weather.usecases.getApplication


val weatherDatabase : WeatherDatabase by lazy {
    initializeDatabase(applicationLiveData.getApplication())
}

@Database(
    entities = [City::class, FavoriteCityId::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(CoordinatesTypeConverter::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract val citiesDao: CitiesDao
    abstract val favoritesDao: FavoritesDao
}
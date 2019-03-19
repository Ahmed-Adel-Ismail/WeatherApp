package com.weather.usecases.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.weather.entities.City
import com.weather.entities.FavoriteCityId

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
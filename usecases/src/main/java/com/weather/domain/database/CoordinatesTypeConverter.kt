package com.weather.domain.database

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.weather.entities.Coordinates

class CoordinatesTypeConverter {

    @TypeConverter
    fun toJson(coordinates: Coordinates) = Gson().toJson(coordinates)


    @TypeConverter
    fun fromJson(string: String) = Gson().fromJson(string, Coordinates::class.java)
}
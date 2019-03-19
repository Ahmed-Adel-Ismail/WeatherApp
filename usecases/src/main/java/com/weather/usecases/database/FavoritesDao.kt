package com.weather.usecases.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface FavoritesDao {

    @Query("select * from FavoriteCityId")
    fun queryAll() : List<Long>

}
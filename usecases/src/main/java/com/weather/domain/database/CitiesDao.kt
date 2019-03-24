package com.weather.domain.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.weather.entities.City

@Dao
interface CitiesDao {

    @Query("select * from City ")
    fun queryAll() : List<City>

    @Query("select * from City where City.name like '%' || :name || '%' ")
    fun queryCitiesByName(name: String) : List<City>

    @Query("select * from City where City.id in (:ids)")
    fun queryCitiesByIds(ids: List<Long>) : List<City>

}
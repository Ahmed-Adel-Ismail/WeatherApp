package com.weather.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import com.google.gson.annotations.SerializedName


@Entity
data class FavoriteCityId(@field:PrimaryKey val id: Long)

@Entity
data class City(
    @field:PrimaryKey
    @field:SerializedName("id") val id: Long,
    @field:SerializedName("name") val name: String?,
    @field:SerializedName("country") val country: String?,
    @field:SerializedName("coord") val coordinates: Coordinates?
)

data class ForecastsResponse(
    @field:SerializedName("city") val city: City?,
    @field:SerializedName("cnt") val count: Long?,
    @field:SerializedName("list") val forecasts: List<Forecast>?
)



data class Coordinates(
    @field:SerializedName("lat") val latitude: Double?,
    @field:SerializedName("lon") val longitude: Double?
)



data class Forecast(
    @field:SerializedName("clouds") val clouds: Clouds?,
    @field:SerializedName("dt") val date: Long?,
    @field:SerializedName("dt_txt") val dateText: String?,
    @field:SerializedName("main") val details: ForecastDetails?,
    @field:SerializedName("snow") val snow: Snow?,
    @field:SerializedName("weather") val weather: List<Weather>?,
    @field:SerializedName("wind") val wind: Wind?
)

data class Clouds(@field:SerializedName("all") val cloudiness: Long?)

data class ForecastDetails(
    @field:SerializedName("grnd_level") val grandLevel: Double?,
    @field:SerializedName("humidity") val humidity: Long?,
    @field:SerializedName("pressure") val pressure: Double?,
    @field:SerializedName("sea_level") val seaLevel: Double?,
    @field:SerializedName("temp") val temperature: Double?,
    @field:SerializedName("temp_max") val maximumTemperature: Double?,
    @field:SerializedName("temp_min") val minimumTemperature: Double?
)

data class Snow(@field:SerializedName("3h") val volumeForLastThreeHours: Double?)

data class Weather(
    @field:SerializedName("description") val description: String?,
    @field:SerializedName("icon") val icon: String?,
    @field:SerializedName("id") val id: Long?,
    @field:SerializedName("main") var state: String?
)

data class Wind(
    @field:SerializedName("deg") val degree: Double?,
    @field:SerializedName("speed") val speed: Double?
)

data class ForecastSummery(
    val dateText: String? = null,
    val cloudiness: String? = null,
    val humidity: String? = null,
    val temperature: String? = null,
    val weather: String? = null,
    val windSpeed: String? = null
)
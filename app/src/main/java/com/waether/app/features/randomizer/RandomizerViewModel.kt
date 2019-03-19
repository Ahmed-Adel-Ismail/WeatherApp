package com.waether.app.features.randomizer

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.weather.usecases.Ticker
import com.weather.usecases.numberIncrementer

const val DEFAULT_VALUE = 0

class RandomizerViewModel : ViewModel() {

    val numberLiveData = MutableLiveData<Int>()

    init {
        numberLiveData.value = DEFAULT_VALUE
    }

    fun incrementNumber(){
        numberIncrementer(numberLiveData)
    }

}
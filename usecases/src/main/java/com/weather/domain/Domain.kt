package com.weather.domain

import android.app.Application
import android.arch.lifecycle.MutableLiveData

internal val applicationLiveData = MutableLiveData<Application>()

internal fun MutableLiveData<Application>.getApplication() = value!!

object Domain {

    fun integrateWith(application: Application) {
        applicationLiveData.value = application
    }

}
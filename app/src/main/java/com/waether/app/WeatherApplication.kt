package com.waether.app

import android.app.Application
import com.waether.app.core.activitiesLifecycleCallbacks
import java.util.function.Consumer

class WeatherApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(activitiesLifecycleCallbacks)
    }
}


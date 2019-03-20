package com.waether.app.core

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.widget.TextView
import com.waether.app.R

val activitiesLifecycleCallbacks by lazy {ActivitiesLifecycleCallbacks()}

class ActivitiesLifecycleCallbacks : Application.ActivityLifecycleCallbacks{

    override fun onActivityPaused(activity: Activity?) {
        
    }

    override fun onActivityResumed(activity: Activity?) {
        
    }

    override fun onActivityStarted(activity: Activity?) {
        
    }

    override fun onActivityDestroyed(activity: Activity?) {
        
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        
    }

    override fun onActivityStopped(activity: Activity?) {
        
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        val layoutId = activity.javaClass
            .getAnnotation(ContentViewId::class.java)
            .layoutId

        activity.setContentView(layoutId)

    }

}




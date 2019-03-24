package com.waether.app.features.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.waether.app.R
import com.waether.app.core.ContentViewId

@ContentViewId(R.layout.activity_main)
class HomeActivity : AppCompatActivity()


class HomeFragment : Fragment(){
    init {
        HomeViewModel()
    }
}
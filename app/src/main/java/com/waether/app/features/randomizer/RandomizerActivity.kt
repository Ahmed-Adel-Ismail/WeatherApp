package com.waether.app.features.randomizer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.waether.app.R
import com.waether.app.core.ContentViewId
import kotlinx.android.synthetic.main.activity_randomizer.*

@ContentViewId(R.layout.activity_randomizer)
class RandomizerActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(RandomizerViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.numberLiveData.observe(this,
            Observer { random_number_textView.text = it.toString() })

        increment_button.setOnClickListener {
            viewModel.incrementNumber()
        }
    }
}


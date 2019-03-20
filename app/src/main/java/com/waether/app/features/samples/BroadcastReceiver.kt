package com.waether.app.features.samples

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.TextView
import android.widget.Toast
import com.waether.app.R
import com.waether.app.features.randomizer.RandomizerViewModel
import kotlinx.android.synthetic.main.activity_randomizer.*

const val ACTION_BUTTON_CLICK = "ACTION_BUTTON_CLICK"


class SampleActivity : FragmentActivity() {


    var view: TextView? = null

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == ACTION_BUTTON_CLICK) {
                view?.text = "clicked"
                Toast.makeText(context, "BUTTON clicked", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_randomizer)
        registerReceiver(receiver, IntentFilter(ACTION_BUTTON_CLICK))

        val viewModel = ViewModelProviders.of(this).get(RandomizerViewModel::class.java)

        viewModel.numberLiveData.observe(this,
            Observer { random_number_textView.text = it.toString() })

        increment_button.setOnClickListener {
            viewModel.incrementNumber()
        }
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }
}


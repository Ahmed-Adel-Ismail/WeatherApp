package com.waether.app.features.samples

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast

class FragmentOne : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activityViewModel = ViewModelProviders.of(activity!!).get(ActivityViewModel::class.java)
        val myViewModel = ViewModelProviders.of(this).get(FragmentOneViewModel::class.java)
        activity?.sendBroadcast(Intent(ACTION_BUTTON_CLICK))
    }
}

class FragmentTwo : Fragment() {

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == ACTION_BUTTON_CLICK) {
                Toast.makeText(context, "BUTTON clicked", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activityViewModel = ViewModelProviders.of(activity!!).get(ActivityViewModel::class.java)
        val myViewModel = ViewModelProviders.of(this).get(FragmentTwoViewModel::class.java)
        activity?.registerReceiver(receiver, IntentFilter(ACTION_BUTTON_CLICK))
    }

    override fun onDestroy() {
        activity?.unregisterReceiver(receiver)
        super.onDestroy()
    }

}

class FragmentOneViewModel : ViewModel()
class FragmentTwoViewModel : ViewModel()
class ActivityViewModel : ViewModel()
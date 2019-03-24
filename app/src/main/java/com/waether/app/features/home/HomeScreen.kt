package com.waether.app.features.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.waether.app.R
import com.waether.app.core.ContentViewId
import kotlinx.android.synthetic.main.fragment_home.*

@ContentViewId(R.layout.activity_main)
class HomeActivity : AppCompatActivity()


class HomeFragment : Fragment() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(HomeViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.searchProgress.observe(this, Observer {
            search_progress_bar.visibility = if (it!!) View.VISIBLE else View.GONE
        })

        viewModel.citiesResult.observe(this, Observer {
            Toast.makeText(activity, "result size = ${it?.size}", Toast.LENGTH_LONG).show()
        })

        search_button.setOnClickListener {
            viewModel.onSearchButtonClicked(search_edit_text.text?.toString())
        }


    }
}
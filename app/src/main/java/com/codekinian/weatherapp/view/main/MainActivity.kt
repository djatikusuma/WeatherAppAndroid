package com.codekinian.weatherapp.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codekinian.weatherapp.R
import com.codekinian.weatherapp.databinding.ActivityMainBinding
import com.codekinian.weatherapp.utils.getViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val city = "Bandung"
        viewModel = getViewModel {
            MainViewModel().apply {
                fetchData(city)
                fetchForecast(city)
                dailyData.observe(this@MainActivity, Observer {
                    if (it.data != null) {
                        binding.rvPrakiraan.apply {
                            layoutManager =
                                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                            adapter =
                                MainAdapter(
                                    it.data?.list!!
                                )
                        }
                    }
                })
            }
        }

        binding.lifecycleOwner = this
        binding.data = viewModel
    }
}

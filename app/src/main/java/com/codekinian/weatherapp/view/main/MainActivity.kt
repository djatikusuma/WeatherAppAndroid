package com.codekinian.weatherapp.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codekinian.weatherapp.R
import com.codekinian.weatherapp.databinding.ActivityMainBinding
import com.codekinian.weatherapp.utils.Constants
import com.codekinian.weatherapp.utils.getViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var city: String
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        city = intent.getStringExtra(Constants.cityPref)!!
        name = intent.getStringExtra(Constants.namePref)!!

        viewModel = getViewModel {
            MainViewModel().apply {
                fetchData(city)
                fetchForecast(city)
                dailyData.observe(this@MainActivity, Observer(this@MainActivity::handleState))
                binding.refreshIndicator.setOnRefreshListener {
                    fetchData(city)
                    fetchForecast(city)
                }
            }
        }

        binding.lifecycleOwner = this
        binding.data = viewModel
    }

    private fun handleState(viewState: DailyViewState) {
        viewState.let {
            toogleLoading(it.loading)
            it.data?.let { data ->
                binding.rvPrakiraan.apply {
                    layoutManager =
                        LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                    adapter =
                        MainAdapter(
                            data.list!!
                        )
                }
            }
        }
    }

    private fun toogleLoading(loading: Boolean) {
        binding.refreshIndicator.isRefreshing = loading
    }
}

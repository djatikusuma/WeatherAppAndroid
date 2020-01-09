package com.codekinian.weatherapp.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.codekinian.weatherapp.R
import com.codekinian.weatherapp.databinding.ActivityMainBinding
import com.codekinian.weatherapp.repository.CurrentWheaterRepository
import com.codekinian.weatherapp.utils.getViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = getViewModel {
            MainViewModel(CurrentWheaterRepository.instance).apply {
                fetchData("Bandung")
            }
        }

        binding.lifecycleOwner = this
        binding.data = viewModel
    }
}

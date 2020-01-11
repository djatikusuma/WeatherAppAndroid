package com.codekinian.weatherapp.view.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.codekinian.weatherapp.R
import com.codekinian.weatherapp.databinding.ActivityLoginBinding
import com.codekinian.weatherapp.utils.Constants
import com.codekinian.weatherapp.utils.getViewModel
import com.codekinian.weatherapp.view.main.MainActivity

class LoginActivity : AppCompatActivity(), LoginCallback {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        viewModel = getViewModel {
            LoginViewModel(this)
        }

        binding.model = viewModel

    }

    override fun onSuccess(userName: String, userCity: String) {
        finishAffinity()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(Constants.namePref, userName)
        intent.putExtra(Constants.cityPref, userCity)
        startActivity(intent)
    }

    override fun onFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}

package com.codekinian.weatherapp.utils

import android.annotation.SuppressLint
import android.text.format.DateFormat
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.util.*
import kotlin.math.round


object Helpers {
    @JvmStatic
    fun kelvinToCelcius(temp: String?): String =
        if (!temp.isNullOrEmpty()) {
            val tempConvert = temp.toDouble() - 273
            round(tempConvert).toInt().toString()
        } else {
            "0"
        }

    @SuppressLint("SimpleDateFormat")
    @JvmStatic
    fun convertLongToTime(time: String?): String =
        if (!time.isNullOrEmpty()) {
            val cal = Calendar.getInstance(Locale.ENGLISH)
            cal.timeInMillis = time.toLong() * 1000
            DateFormat.format("EEEE, dd MMM yyyy", cal).toString()
        } else {
            "-"
        }

    @JvmStatic
    fun getMessageDay(): String {
        val c = Calendar.getInstance()
        return when (c[Calendar.HOUR_OF_DAY]) {
            in 0..11 -> {
                "Selamat pagi,"
            }
            in 12..15 -> {
                "Selamat siang,"
            }
            in 16..18 -> {
                "Selamat sore,"
            }
            in 19..23 -> {
                "Selamat malam,"
            }
            else -> {
                ""
            }
        }
    }

    @JvmStatic
    fun getWeatherDay(type: String?): String =
        if (!type.isNullOrEmpty()) {
            when (type) {
                "Rain" -> {
                    "Hujan"
                }
                "Clouds" -> {
                    "Berawan"
                }
                "Clear" -> {
                    "Cerah"
                }
                else -> {
                    "Cerah"
                }
            }
        } else {
            "-"
        }

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view: ImageView?, icon: String?) {
        if (view != null && icon != null) {
            Glide.with(view.context).load(Constants.IMG_URL + icon + "@2x.png").into(view)
        }
    }
}
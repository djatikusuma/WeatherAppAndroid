package com.codekinian.weatherapp.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.codekinian.weatherapp.data.model.daily.ListClouds
import com.codekinian.weatherapp.databinding.ItemListWeatherBinding
import kotlinx.android.extensions.LayoutContainer

class MainAdapter(
    private val trucks: MutableList<ListClouds>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemListWeatherBinding.inflate(LayoutInflater.from(parent.context))
        )

    override fun getItemCount() = trucks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(trucks[position])
    }

    class ViewHolder(private var binding: ItemListWeatherBinding) :
        RecyclerView.ViewHolder(binding.root), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bindItem(item: ListClouds) {
            containerView?.context.let {
                binding.setVariable(BR.item, item)
                binding.executePendingBindings()
            }
        }
    }
}
package com.example.konrad.portfolio.ui.countries

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater

import android.view.ViewGroup
import com.example.konrad.portfolio.R
import com.example.konrad.portfolio.databinding.CountriesItemBinding
import com.example.konrad.portfolio.model.Countries

class CountriesListAdapter(): RecyclerView.Adapter<CountriesListAdapter.ViewHolder>() {
    private lateinit var countryList :List<Countries>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesListAdapter.ViewHolder {
        val binding: CountriesItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.countries_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountriesListAdapter.ViewHolder, position: Int) {
        holder.bind(countryList[position])
    }

    override fun getItemCount(): Int {
        return if(::countryList.isInitialized) countryList.size else 0
    }

    fun updatePostList(countryList:List<Countries>){
        this.countryList = countryList
        notifyDataSetChanged()
    }

    fun getCountryList(): List<Countries>{
        return countryList
    }

    class ViewHolder(private val binding: CountriesItemBinding): RecyclerView.ViewHolder(binding.root){


        private val viewModel = CountriesViewModel()

        fun bind(country:Countries){
            viewModel.bind(country)
            binding.viewModel = viewModel
        }
    }
}
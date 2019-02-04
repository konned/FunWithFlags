package com.example.konrad.portfolio.ui.countries

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.example.konrad.portfolio.base.BaseViewModel
import com.example.konrad.portfolio.model.Countries
import com.squareup.picasso.Picasso
import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.konrad.portfolio.R




class CountriesViewModel: BaseViewModel(){
    private val countryTitle = MutableLiveData<String>()
    private val countryBody = MutableLiveData<String>()
    private val countryFlagUrl = MutableLiveData<String>()

    fun bind(country: Countries){
        countryTitle.value = country.name
        countryBody.value = country.capital
        countryFlagUrl.value = country.flag
    }

    fun getCountryTitle(): MutableLiveData<String> {
        return countryTitle
    }

    fun getCountryBody(): MutableLiveData<String> {
        return countryBody
    }

    fun getFlagUrl(): MutableLiveData<String>{
        return countryFlagUrl
    }
}
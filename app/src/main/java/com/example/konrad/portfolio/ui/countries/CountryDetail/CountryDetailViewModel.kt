package com.example.konrad.portfolio.ui.countries.CountryDetail

import android.arch.lifecycle.MutableLiveData
import com.example.konrad.portfolio.base.BaseViewModel
import com.example.konrad.portfolio.model.Countries

class CountryDetailViewModel: BaseViewModel() {

    private val countryFlagUrl = MutableLiveData<String>()
    private val countryName = MutableLiveData<String>()
    private val countryCommonName = MutableLiveData<String>()
    private val countryDemonym = MutableLiveData<String>()
    private val countryAlphaCode = MutableLiveData<String>()
    private val countryOfficialNative = MutableLiveData<String>()
    private val countryAlternativeSpellings = MutableLiveData<String>()
    val sb : java.lang.StringBuilder = StringBuilder()

    fun bind(country: Countries){
        countryFlagUrl.value = country.flag
        countryName.value = country.name
        countryCommonName.value = country.name
        countryOfficialNative.value = country.nativeName

        country.altSpellings.forEach{spelling->
            sb.append(spelling).append(", ").append("\n")
        }

        countryAlternativeSpellings.value = sb.toString()
        countryDemonym.value = country.demonym
        countryAlphaCode.value = country.alpha3Code

    }

    fun getCountryFlagUrl(): MutableLiveData<String> {
        return countryFlagUrl
    }

    fun getCountryName(): MutableLiveData<String> {
        return countryName
    }

    fun getCountryCommonName(): MutableLiveData<String>{
        return countryCommonName
    }

    fun getCountryOfficialNative(): MutableLiveData<String> {
        return countryOfficialNative
    }

    fun getCountryAlternativeSpelling(): MutableLiveData<String> {
        return countryAlternativeSpellings
    }

    fun getCountryDemonym(): MutableLiveData<String>{
        return countryDemonym
    }

    fun getCountryAlphaCode(): MutableLiveData<String>{
        return countryAlphaCode
    }
}
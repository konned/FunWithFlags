package com.example.konrad.portfolio.base

import android.arch.lifecycle.ViewModel
import com.example.konrad.portfolio.injection.component.DaggerViewModelInjector
import com.example.konrad.portfolio.injection.component.ViewModelInjector
import com.example.konrad.portfolio.injection.module.NetworkModule
import com.example.konrad.portfolio.ui.countries.CountriesListViewModel
import com.example.konrad.portfolio.ui.countries.CountriesViewModel


abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is CountriesListViewModel -> injector.inject(this)
            is CountriesViewModel -> injector.inject(this)
        }
    }
}
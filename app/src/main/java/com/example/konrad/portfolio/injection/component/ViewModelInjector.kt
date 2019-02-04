package com.example.konrad.portfolio.injection.component

import com.example.konrad.portfolio.injection.module.NetworkModule
import com.example.konrad.portfolio.ui.countries.CountriesListViewModel
import com.example.konrad.portfolio.ui.countries.CountriesViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param postListViewModel PostListViewModel in which to inject the dependencies
     */
    fun inject(countriesListViewModel: CountriesListViewModel)
    /**
     * Injects required dependencies into the specified PostViewModel.
     * @param postViewModel PostViewModel in which to inject the dependencies
     */
    fun inject(countriesViewModel: CountriesViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}
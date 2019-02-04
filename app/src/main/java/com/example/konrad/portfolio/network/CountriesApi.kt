package com.example.konrad.portfolio.network

import com.example.konrad.portfolio.model.Countries
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface CountriesApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/rest/v2/all")
    fun getCountries(): Observable<List<Countries>>
}
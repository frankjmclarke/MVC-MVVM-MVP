package com.fclarke.mvc_mvp_mvvm.model

import io.reactivex.Single
import retrofit2.http.GET

interface CountriesService {
    @GET("all")
    fun getCountries(): Single<List<CountryInterface>>
}

package com.fclarke.mvc_mvp_mvvm.mvc

import io.reactivex.Single
import retrofit2.http.GET

interface CountriesService {
    @GET("all")
    open fun getCountries(): Single<List<CountryInterface>>
}

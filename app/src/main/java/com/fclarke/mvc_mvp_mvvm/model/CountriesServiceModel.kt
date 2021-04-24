package com.fclarke.mvc_mvp_mvvm.model

import com.fclarke.mvc_mvp_mvvm.mvc.CountryInterface
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class CountriesServiceModel {
    private val api: CountriesService
    //val countries: Single<List<CountryInterface>>
    //    get() = api.getCountries()
    fun getCountries(): Single<List<CountryInterface>> {
        return api.getCountries()
     }

    companion object {
        const val BASE_URL = "https://restcountries.eu/rest/v2/"
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        api = retrofit.create(CountriesService::class.java)
    }


}

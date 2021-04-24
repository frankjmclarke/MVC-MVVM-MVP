package com.fclarke.mvc_mvp_mvvm.mvc

import com.fclarke.mvc_mvp_mvvm.Country
import com.fclarke.mvc_mvp_mvvm.Hero
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface CountryInterface2 {
    @GET("/rest/v2/all")
    fun getCountries(): Call<List<Country>>
}

class CountryInterface {
    @SerializedName("name")
    var countryName: String? = null
}
interface superheroAPIold {
    @GET("marvel") // making get request at marvel end-point
    fun getHeroes(): Call<List<Hero?>?>?
}

interface ApiService {

    @GET("users")
    fun getUsers(): Call<MutableList<Country>>

}

package com.fclarke.mvc_mvp_mvvm.mvc

import com.fclarke.mvc_mvp_mvvm.Country
import com.fclarke.mvc_mvp_mvvm.Hero
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

class CountryInterface {
    @SerializedName("name")
    var countryName: String? = null
}

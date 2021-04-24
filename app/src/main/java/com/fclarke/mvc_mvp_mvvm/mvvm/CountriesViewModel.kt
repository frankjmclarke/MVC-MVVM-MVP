package com.fclarke.mvc_mvp_mvvm.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.fclarke.mvc_mvp_mvvm.model.CountriesServiceModel
import com.fclarke.mvc_mvp_mvvm.model.CountryInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CountriesViewModel : ViewModel() {
    private var service: CountriesServiceModel? = null

    private val countries: MutableLiveData<List<String>> = MutableLiveData()
    private val countryError: MutableLiveData<Boolean> = MutableLiveData()

    init {//does not have a View reference
        service = CountriesServiceModel()
        fetchCountries()
    }

    fun getCountries(): LiveData<List<String>> {
        return countries
    }

    fun getCountryError(): LiveData<Boolean> {
        return countryError
    }

    private fun fetchCountries() {
        service!!.getCountries()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<CountryInterface?>?>() {
                override fun onSuccess(value: List<CountryInterface?>) {
                    val countryNames: MutableList<String> = mutableListOf()
                    for (country in value) {
                        if (country != null) {
                            country.countryName?.let { countryNames.add(it) }
                        }
                    }
                    countries?.setValue(countryNames.toList())
                    countryError.value = false
                }

                override fun onError(e: Throwable) {
                    countryError.value = true
                }
            })
    }

    fun onRefresh() {
        fetchCountries()
    }
}
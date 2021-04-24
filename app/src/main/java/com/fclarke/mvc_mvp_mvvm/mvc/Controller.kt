package com.fclarke.mvc_mvp_mvvm.mvc

import com.fclarke.mvc_mvp_mvvm.model.CountriesServiceModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class Controller (vi:MVCActivityView){
    private var view: MVCActivityView? = null
    private var service: CountriesServiceModel? = null

    init {
        view = vi
        service = CountriesServiceModel()
        fetchCountries()
    }

    private fun fetchCountries() {
        service!!.getCountries()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<CountryInterface?>?>() {
                override fun onSuccess(value: List<CountryInterface?>) {
                    val countryNames: MutableList<String?> = mutableListOf()
                    for (country in value) {
                        if (country != null) {
                            countryNames.add(country.countryName)
                        }
                    }
                    view?.setValues(countryNames)
                }

                override fun onError(e: Throwable) {
                    view?.onError()
                }
            })
    }

    fun onRefresh() {
        fetchCountries()
    }
}
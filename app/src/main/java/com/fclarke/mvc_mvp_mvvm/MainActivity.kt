package com.fclarke.mvc_mvp_mvvm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fclarke.mvc_mvp_mvvm.mvc.MVCActivityView
import com.fclarke.mvc_mvp_mvvm.mvp.MVPActivityView
import com.fclarke.mvc_mvp_mvvm.mvvm.MVVMActivityView


data class Language(val name: String)
data class Country(val name: String, val capital: String, val languages: List<Language>)

data class Hero(var name: String, var realname: String, var team: String, var firstappearance: String, var createdby: String, var publisher: String, var imageurl: String, var bio: String)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMVC: Button = findViewById(R.id.btnMVC)
        val btnMVP: Button = findViewById(R.id.btnMVP)
        val btnMVVM: Button = findViewById(R.id.btnMVVP)


        btnMVC.setOnClickListener {
            val intent = Intent(this, MVCActivityView::class.java)
            startActivity(intent)
        }
        btnMVP.setOnClickListener {
            val intent = Intent(this, MVPActivityView::class.java)
            startActivity(intent)
        }
        btnMVVM.setOnClickListener {
            val intent = Intent(this, MVVMActivityView::class.java)
            startActivity(intent)
        }

    }
/*
    companion object {
        const val URL_COUNTRY_API = "https://restcountries.eu/"
    }

    val retro = Retrofit.Builder()
        .baseUrl(URL_COUNTRY_API)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val service = retro.create(CountryInterface::class.java)//!!

    val countryRequest = service.countryName

    countryRequest.enqueue(object : Callback<List<Country>> {
        override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
            val allCountry = response.body()
            for (c in allCountry!!)
                Log.v(
                    MainActivity::class.simpleName,
                    "NAME: ${c.name} \n CAPITAL: ${c.capital} \n Language: ${c.languages} "
                )
        }


        override fun onFailure(call: Call<List<Country>>, t: Throwable) {
            Log.i(MainActivity::class.simpleName, "on FAILURE!!!!")
        }

    })
*/

}




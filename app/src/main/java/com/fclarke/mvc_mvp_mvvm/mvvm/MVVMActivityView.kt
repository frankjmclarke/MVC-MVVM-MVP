package com.fclarke.mvc_mvp_mvvm.mvvm

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.fclarke.mvc_mvp_mvvm.R
import java.util.*


class MVVMActivityView : AppCompatActivity() {

    private val listValues = mutableListOf<String?>()
    private var adapter: ArrayAdapter<String>? = null
    private var list: ListView? = null
    private var viewModel: CountriesViewModel? = null
    private var retryButton: Button? = null
    private var progress: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        title = "MVC Activity"

        viewModel = ViewModelProviders.of(this).get(CountriesViewModel::class.java)

        list = findViewById(R.id.list)
        retryButton = findViewById(R.id.retryButton)
        progress = findViewById(R.id.progress)
        adapter = ArrayAdapter<String>(this, R.layout.row_layout, R.id.listText, listValues)

        list?.adapter = adapter
        list?.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this@MVVMActivityView,
                "You clicked " + listValues[position],
                Toast.LENGTH_SHORT
            ).show()
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel?.getCountries()?.observe(this) { countries ->
            if (countries != null) {
                listValues.clear()
                listValues.addAll(countries)
                list!!.visibility = View.VISIBLE
                adapter!!.notifyDataSetChanged()
            } else {
                list!!.visibility = View.GONE
            }
        }
        viewModel?.getCountryError()?.observe(this) { error ->
            progress!!.visibility = View.GONE
            if (error) {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT)
                    .show()
                retryButton!!.visibility = View.VISIBLE
            } else {
                retryButton!!.visibility = View.GONE
            }
        }
    }

    fun onRetry(view: View?) {
        viewModel?.onRefresh()
        list!!.visibility = View.GONE
        retryButton!!.visibility = View.GONE
        progress!!.visibility = View.VISIBLE
    }
}
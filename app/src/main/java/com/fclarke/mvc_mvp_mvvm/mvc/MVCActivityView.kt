package com.fclarke.mvc_mvp_mvvm.mvc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import com.fclarke.mvc_mvp_mvvm.R
import java.util.*


class MVCActivityView : AppCompatActivity() {
    private val listValues = mutableListOf<String?>()
    private var adapter: ArrayAdapter<String>? = null
    private var list: ListView? = null
    private var controller: Controller? = null
    private var retryButton: Button? = null
    private var progress: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc)
        title = "MVC Activity"

        controller = Controller(this)

        list = findViewById(R.id.list)
        retryButton = findViewById(R.id.retryButton)
        progress = findViewById(R.id.progress)
        adapter = ArrayAdapter<String>(this, R.layout.row_layout, R.id.listText, listValues)

        list?.setAdapter(adapter)
        list?.setOnItemClickListener({ parent, view, position, id ->
            Toast.makeText(
                this@MVCActivityView,
                "You clicked " + listValues[position],
                Toast.LENGTH_SHORT
            ).show()
        })
        val vals = mutableListOf<String?>()
        vals.add("UK")
        vals.add("USA")
        vals.add("Canada")
        vals.add("Uganda")
        vals.add("Nigeria")
        vals.add("Ireland")
        vals.add("UK")
        vals.add("USA")
        vals.add("Canada")
        vals.add("Uganda")
        vals.add("Nigeria")
        vals.add("Ireland")
        setValues(vals)

    }

    fun setValues(values: MutableList<String?>) {
        listValues.clear()
        listValues.addAll(values.toCollection(mutableListOf()))
        retryButton!!.visibility = View.GONE
        progress!!.visibility = View.GONE
        list!!.visibility = View.VISIBLE
        adapter!!.notifyDataSetChanged()
    }

    fun onRetry(view: View?) {
        controller?.onRefresh()
        list!!.visibility = View.GONE
        retryButton!!.visibility = View.GONE
        progress!!.visibility = View.VISIBLE
    }

    fun onError() {
        Toast.makeText(this, "Unable to get country names. Please retry later", Toast.LENGTH_SHORT)
            .show()
        progress!!.visibility = View.GONE
        list!!.visibility = View.GONE
        retryButton!!.visibility = View.VISIBLE
    }

}
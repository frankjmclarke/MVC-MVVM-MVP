package com.fclarke.mvc_mvp_mvvm.mvc

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.fclarke.mvc_mvp_mvvm.R
import java.util.*



class MVCActivityView : AppCompatActivity() {
    private val listValues: List<String> = ArrayList()
    private var adapter: ArrayAdapter<String>? = null
    private var list: ListView? = null
    //private var controller: Controller? = null
    private var retryButton: Button? = null
    private var progress: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc)
        title = "MVC Activity"

        //controller = Controller(this)

        list = findViewById(R.id.list)
        retryButton = findViewById(R.id.retryButton)
        progress = findViewById(R.id.progress)
        adapter = ArrayAdapter<String>(this, R.layout.row_layout, R.id.listText, listValues)

    }
    fun onRetry(view: View?) {
        //controller.onRefresh()
        list!!.visibility = View.GONE
        retryButton!!.visibility = View.GONE
        progress!!.visibility = View.VISIBLE
    }
}
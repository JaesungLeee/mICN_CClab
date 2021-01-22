package com.example.micnjs.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.micnjs.R
import com.example.micnjs.adapters.myReportsAdapter
import com.example.micnjs.models.myReportsModel
import kotlinx.android.synthetic.main.activity_my_reports.*

class myReports : AppCompatActivity() {

    val reportsList = ArrayList<myReportsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_reports)

        initData()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        myReports_rV.layoutManager = LinearLayoutManager(this)
        myReports_rV.setHasFixedSize(true)
        myReports_rV.adapter = myReportsAdapter(reportsList)
    }

    private fun initData() {
        reportsList.add(
            myReportsModel(
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        )
        )

        reportsList.add(myReportsModel(
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        ))

        reportsList.add(myReportsModel(
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        ))

        reportsList.add(
            myReportsModel(
                "Lee",
                "Dr.Kim",
                "Hostpital A"
            )
        )

        reportsList.add(myReportsModel(
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        ))

        reportsList.add(myReportsModel(
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        ))
    }
}
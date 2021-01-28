package com.example.micnjs.UI.careGiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.micnjs.R
import com.example.micnjs.RVadapters.careGiverReportsAdapter
import com.example.micnjs.RVmodels.careGiverReportsModel
import kotlinx.android.synthetic.main.activity_care_giver_reports.*
import kotlinx.android.synthetic.main.care_giver_reports_layout.*

class careGiverReports : AppCompatActivity() {

    val reportsList = ArrayList<careGiverReportsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_care_giver_reports)



        initData()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        careGiverReports_rV.layoutManager = LinearLayoutManager(this)
        careGiverReports_rV.setHasFixedSize(true)
        careGiverReports_rV.adapter = careGiverReportsAdapter(reportsList)
    }

    private fun initData() {
        reportsList.add(
                careGiverReportsModel(
                        "Mr. Seo-jun",
                        "Dr. Nazib",
                        "Hostpital A"
                )
        )

        reportsList.add(
                careGiverReportsModel(
                        "Mrs. Ha-eun",
                        "Dr. Nazib",
                        "Hostpital A"
                )
        )

        reportsList.add(
                careGiverReportsModel(
                        "Ms. Soo-ah",
                        "Dr. Nazib",
                        "Hostpital A"
                )
        )

        reportsList.add(
                careGiverReportsModel(
                        "Mr. Ye-jun",
                        "Dr. Nazib",
                        "Hostpital A"
                )
        )

        reportsList.add(
                careGiverReportsModel(
                        "Mr. Lee",
                        "Dr. Nazib",
                        "Hostpital A"
                )
        )
    }
}
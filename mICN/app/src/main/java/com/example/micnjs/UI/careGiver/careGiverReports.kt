package com.example.micnjs.UI.careGiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.micnjs.R
import com.example.micnjs.adapters.careGiverReportsAdapter
import com.example.micnjs.models.careGiverReportsModel
import kotlinx.android.synthetic.main.activity_care_giver_reports.*

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
                "Lee",
                "Dr.Kim",
                "Hostpital A"
            )
        )

        reportsList.add(
            careGiverReportsModel(
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        )
        )

        reportsList.add(
            careGiverReportsModel(
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        )
        )

        reportsList.add(
            careGiverReportsModel(
                "Lee",
                "Dr.Kim",
                "Hostpital A"
            )
        )

        reportsList.add(
            careGiverReportsModel(
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        )
        )

        reportsList.add(
            careGiverReportsModel(
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        )
        )
    }
}
package com.example.micnjs.UI.patient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.micnjs.R
import com.example.micnjs.RVadapters.patientReportsAdapter
import com.example.micnjs.RVmodels.patientReportsModel
import kotlinx.android.synthetic.main.activity_patient_reports.*


class patientReports : AppCompatActivity() {

    val reportsList = ArrayList<patientReportsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_reports)

        initData()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        patientReports_rV.layoutManager = LinearLayoutManager(this)
        patientReports_rV.setHasFixedSize(true)
        patientReports_rV.adapter = patientReportsAdapter(reportsList)
    }

    private fun initData() {
        reportsList.add(
            patientReportsModel(
            "Report 1",
            "Doctor: Dr. Eun",
            "Hospital A"
            )
        )

        reportsList.add(
            patientReportsModel(
            "Report 2",
            "Doctor: Dr. Kim",
            "Hostpital B"
            )
        )

        reportsList.add(
            patientReportsModel(
            "Report 3",
            "Doctor: Dr. Park",
            "Hostpital A"
            )
        )

    }
}
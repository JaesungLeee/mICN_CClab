package com.example.micnjs.UI.patient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.micnjs.R
import com.example.micnjs.adapters.patientReportsAdapter
import com.example.micnjs.models.patientReportsModel
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
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        )
        )

        reportsList.add(patientReportsModel(
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        ))

        reportsList.add(patientReportsModel(
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        ))

        reportsList.add(
            patientReportsModel(
                "Lee",
                "Dr.Kim",
                "Hostpital A"
            )
        )

        reportsList.add(patientReportsModel(
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        ))

        reportsList.add(patientReportsModel(
            "Lee",
            "Dr.Kim",
            "Hostpital A"
        ))
    }
}
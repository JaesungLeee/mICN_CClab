package com.example.micnjs.UI.careGiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.micnjs.R
import com.example.micnjs.adapters.myPatientsAdapter
import com.example.micnjs.models.myPatientsModel
import kotlinx.android.synthetic.main.activity_my_patients.*

class myPatients : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_patients)

        val patientList = arrayListOf(
            myPatientsModel("Lee"),
            myPatientsModel("Park"),
            myPatientsModel("Kim"),
            myPatientsModel("Jeong"),
            myPatientsModel("Hong"),
            myPatientsModel("Lee"),
            myPatientsModel("Park"),
            myPatientsModel("Kim"),
            myPatientsModel("Jeong"),
            myPatientsModel("Hong"),
            myPatientsModel("Lee"),
            myPatientsModel("Park"),
            myPatientsModel("Kim"),
            myPatientsModel("Jeong"),
            myPatientsModel("Hong")
        )

        myPatients_rV.layoutManager = LinearLayoutManager(this)
        myPatients_rV.setHasFixedSize(true)
        myPatients_rV.adapter = myPatientsAdapter(patientList)
    }
}
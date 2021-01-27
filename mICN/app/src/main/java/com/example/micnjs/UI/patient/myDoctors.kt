package com.example.micnjs.UI.patient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.micnjs.R
import com.example.micnjs.RVadapters.myDoctorsAdapter
import com.example.micnjs.RVmodels.myDoctorsModel
import kotlinx.android.synthetic.main.activity_my_doctors.*

class myDoctors : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_doctors)

        val doctorList = arrayListOf<myDoctorsModel>(
                myDoctorsModel("Dr. Eun; Family Physician"),
                myDoctorsModel("Dr. Park; Dermatologist"),
                myDoctorsModel("Dr. Kim; Surgeon"),
                myDoctorsModel("Dr. Min; Pediatrician")
        )

        myDoctors_rV.layoutManager = LinearLayoutManager(this)
        myDoctors_rV.setHasFixedSize(true)
        myDoctors_rV.adapter = myDoctorsAdapter(doctorList)
    }
}
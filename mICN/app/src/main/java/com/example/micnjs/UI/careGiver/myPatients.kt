package com.example.micnjs.UI.careGiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.micnjs.R
import com.example.micnjs.RVadapters.myPatientsAdapter
import com.example.micnjs.RVmodels.myPatientsModel
import kotlinx.android.synthetic.main.activity_my_patients.*

class myPatients : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_patients)

        val patientList = arrayListOf(
                myPatientsModel("Mr. Seo-jun; 24 yr; Ansan"),
                myPatientsModel("Mrs. Ha-eun; 56 yr; Anseong"),
                myPatientsModel("Ms. Soo-ah; 19 yr; Gimpo"),
                myPatientsModel("Mr. Ye-jun; 35 yr; Hanam"),
                myPatientsModel("Mr. Lee; 30 yr; Yongin")
        )

        myPatients_rV.layoutManager = LinearLayoutManager(this)
        myPatients_rV.setHasFixedSize(true)
        myPatients_rV.adapter = myPatientsAdapter(patientList)
    }
}
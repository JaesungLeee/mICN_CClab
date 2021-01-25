package com.example.micnjs.UI.patient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.micnjs.R
import kotlinx.android.synthetic.main.activity_patient_retrieve_info.*

class patientRetrieveInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_retrieve_info)

        connectServer_btn.setOnClickListener {
            // Implement of Connecting with Server
            connectServer_tV.visibility = View.VISIBLE
            contents_btn.visibility = View.VISIBLE
        }

        moveBack_btn.setOnClickListener {
            finish()
        }

        contents_btn.setOnClickListener {
            val intent = Intent(this, patientContents::class.java)
            startActivity(intent)
        }
    }
}
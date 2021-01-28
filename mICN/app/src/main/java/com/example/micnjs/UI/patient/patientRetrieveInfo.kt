package com.example.micnjs.UI.patient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.micnjs.R
import kotlinx.android.synthetic.main.activity_patient_retrieve_info.*

class patientRetrieveInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_retrieve_info)

        download_btn.setOnClickListener {
            Toast.makeText(this, "Download Successful.", Toast.LENGTH_LONG).show()
        }


        moveBack_btn.setOnClickListener {
            finish()
        }


    }
}
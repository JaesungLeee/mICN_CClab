package com.example.micnjs.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.micnjs.R
import kotlinx.android.synthetic.main.activity_patient_home.*

class patientHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_home)

        updateProfile_btn.setOnClickListener {
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }

    }
}
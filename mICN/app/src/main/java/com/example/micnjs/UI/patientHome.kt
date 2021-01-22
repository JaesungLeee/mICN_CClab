package com.example.micnjs.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.micnjs.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_patient_home.*

class patientHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_home)

        updateProfile_btn.setOnClickListener {
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }

        retreiveInfo_btn.setOnClickListener {
            val intent = Intent(this, retrieveInfo::class.java)
            startActivity(intent)
        }

        pEmergency_btn.setOnClickListener {
            val intent = Intent(this, emergency::class.java)
            startActivity(intent)
        }

        doctors_btn.setOnClickListener {
            val intent = Intent(this, myDoctors::class.java)
            startActivity(intent)
        }

        reports_btn.setOnClickListener {
            val intent = Intent(this, myReports::class.java)
            startActivity(intent)
        }

        pLogout_btn.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        FirebaseAuth.getInstance().signOut()
        Toast.makeText(this, "Logout Successful", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, login::class.java)
        startActivity(intent)
        finish()
    }
}
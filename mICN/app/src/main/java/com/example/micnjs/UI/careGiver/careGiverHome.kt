package com.example.micnjs.UI.careGiver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.micnjs.R
import com.example.micnjs.UI.*
import com.example.micnjs.UI.auth.login
import com.example.micnjs.UI.patient.patientRetrieveInfo
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_care_giver_home.*

class careGiverHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_care_giver_home)

        updateProfile_btn.setOnClickListener {
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }

        cPatients_btn.setOnClickListener {
            val intent = Intent(this, myPatients::class.java)
            startActivity(intent)
        }

        cReports_btn.setOnClickListener {
            val intent = Intent(this, careGiverReports::class.java)
            startActivity(intent)
        }

        retreiveInfo_btn.setOnClickListener {
            val intent = Intent(this, patientRetrieveInfo::class.java)
            startActivity(intent)
        }

        cLogout_btn.setOnClickListener {
            logout()
        }

        cEmergency_btn.setOnClickListener {
            val intent = Intent(this, emergency::class.java)
            startActivity(intent)
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
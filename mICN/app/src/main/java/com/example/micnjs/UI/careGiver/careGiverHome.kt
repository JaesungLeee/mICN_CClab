package com.example.micnjs.UI.careGiver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.micnjs.R
import com.example.micnjs.UI.*
import com.example.micnjs.UI.auth.login
import com.example.micnjs.UI.patient.patientHome
import com.example.micnjs.UI.patient.patientRetrieveInfo
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_care_giver_home.*

class careGiverHome : AppCompatActivity() {

    companion object {
        private var USERUID = "USERUID"
        private var USERNICKNAME = "USERNICKNAME"
        private var USERFULLNAME = "USERFULLNAME"
        private var USEREMAIL = "USEREMAIL"
        private var USERPW = "USERPW"
        private var USERBIRTH = "USERBIRTH"
        private var USERTYPE = "USERTYPE"
    }

    var userUid = ""
    var userNickName = ""
    var userFullName = ""
    var userEmail = ""
    var userPW = ""
    var userBirth = ""
    var userType = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_care_giver_home)

        userUid = intent.getStringExtra(USERUID).toString()
        userNickName = intent.getStringExtra(USERNICKNAME).toString()
        userFullName = intent.getStringExtra(USERFULLNAME).toString()
        userEmail = intent.getStringExtra(USEREMAIL).toString()
        userPW = intent.getStringExtra(USERPW).toString()
        userBirth = intent.getStringExtra(USERBIRTH).toString()
        userType = intent.getStringExtra(USERTYPE).toString()

        Log.e("USERINFO", "uid : ${userUid}, nickname : ${userNickName}, password : ${userPW}, birth : ${userBirth}")

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
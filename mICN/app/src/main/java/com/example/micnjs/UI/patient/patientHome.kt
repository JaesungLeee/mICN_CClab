package com.example.micnjs.UI.patient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.micnjs.R
import com.example.micnjs.UI.*
import com.example.micnjs.UI.auth.login
import com.example.micnjs.UI.auth.signup
import com.example.micnjs.UI.careGiver.careGiverHome
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_patient_home.*

class patientHome : AppCompatActivity() {
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
        setContentView(R.layout.activity_patient_home)

        userUid = intent.getStringExtra(USERUID).toString()
        userNickName = intent.getStringExtra(USERNICKNAME).toString()
        userFullName = intent.getStringExtra(USERFULLNAME).toString()
        userEmail = intent.getStringExtra(USEREMAIL).toString()
        userPW = intent.getStringExtra(USERPW).toString()
        userBirth = intent.getStringExtra(USERBIRTH).toString()
        userType = intent.getStringExtra(USERTYPE).toString()

        Log.e("USERINFO", "uid : ${userUid}, nickname : ${userNickName}, password : ${userPW}, birth : ${userBirth}")

        welcome_tV.text = "Welcome ${userNickName}. How are you doing today?"

        btnClickListener()
    }


    private fun logout() {
        FirebaseAuth.getInstance().signOut()
        Toast.makeText(this, "Logout Successful", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, login::class.java)
        startActivity(intent)
        finish()
    }

    private fun btnClickListener() {
        updateProfile_btn.setOnClickListener {
            val intent = Intent(this, profile::class.java).apply {
                putExtra(USERUID, userUid)
//                putExtra(USERNICKNAME, userNickName)
//                putExtra(USERFULLNAME, userFullName)
//                putExtra(USEREMAIL, userEmail)
                putExtra(USERPW, userPW)
//                putExtra(USERBIRTH, userBirth)
//                putExtra(USERTYPE, userType)
            }
            startActivity(intent)
        }

        retreiveInfo_btn.setOnClickListener {
            val intent = Intent(this, patientRetrieveInfo::class.java)
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
            val intent = Intent(this, patientReports::class.java)
            startActivity(intent)
        }

        pLogout_btn.setOnClickListener {
            logout()
        }

    }
}
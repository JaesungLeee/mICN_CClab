package com.example.micnjs.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.micnjs.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_profile.*

class profile : AppCompatActivity() {

    companion object {
        private var USERUID = "USERUID"
        private var USERNICKNAME = "USERNICKNAME"
        private var USERFULLNAME = "USERFULLNAME"
        private var USEREMAIL = "USEREMAIL"
        private var USERPW = "USERPW"
        private var USERBIRTH = "USERBIRTH"
        private var USERTYPE = "USERTYPE"
    }

    var databaseReference : DatabaseReference? = null
    var database : FirebaseDatabase? = null

    var userUid = ""
    var userPW = ""

    private var datePickerBirth = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("User")

        userUid = intent.getStringExtra(USERUID).toString()
//        userNickName = intent.getStringExtra(USERNICKNAME).toString()
//        userEmail = intent.getStringExtra(USEREMAIL).toString()
        userPW = intent.getStringExtra(USERPW).toString()
//        userType = intent.getStringExtra(USERTYPE).toString()

        Log.e("PASSWORD", userPW)

//        initUserInfo()

        profileSave_btn.setOnClickListener {
            // Implement Save Info action to Database

            var userFullName = userFullName_eT.text.toString()
            var userBirth = datePickerBirth

            changePassword()
//            setUserFullName(userFullName)
            setUserBirth()

            updateDB(userFullName, userBirth)
            Toast.makeText(this, "Your Information successfully saved", Toast.LENGTH_SHORT).show()
            finish()
        }

        profileBack_btn.setOnClickListener {
            finish()
        }

//        delete_btn.setOnClickListener {
//            deleteTask()
//        }
    }

//    private fun initUserInfo() {
//        Log.e("INITUSERINFO", userFullName)
//        userFullName_eT.text = Editable.Factory.getInstance().newEditable(userFullName)
//
//
//    }

//    private fun setUserFullName(userFullName: String) {
//        userFullName = userFullName_eT.text.toString()
//    }

    private fun changePassword() {
        if (userPW == previousPW_eT.text.toString()) {

            if (changePW_eT.text.toString() == changeCPW_eT.text.toString()) {
                userPW = changePW_eT.text.toString()
            }
            else {
                Toast.makeText(applicationContext, "Check password again", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(applicationContext, "Previous password is wrong", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setUserBirth() {
        var birthY = datePicker.year.toString()
        var birthM = datePicker.month.toString()
        var birthD = datePicker.dayOfMonth.toString()

        datePickerBirth = "$birthY-$birthM-$birthD"
//        Log.e("USERBIRTH", userBirth)
    }

    private fun updateDB(userFullName: String, userBirth: String) {
        val userReference = databaseReference?.child(userUid)

        if (!TextUtils.isEmpty(userFullName)) {
            userReference?.child("fullName")?.setValue(userFullName)
        }

        userReference?.child("password")?.setValue(userPW)
        userReference?.child("birth")?.setValue(userBirth)

        Log.e("USERFULLNAME", userFullName)

    }

//    private fun deleteTask() {
//        databaseReference!!.child("l26p4UVo16fFZuqadrUKCq1Eqb62").removeValue()
//        Toast.makeText(applicationContext, "Successfully deleted user", Toast.LENGTH_SHORT).show()
//    }
}
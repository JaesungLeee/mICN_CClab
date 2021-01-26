package com.example.micnjs.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.micnjs.R
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
//        var birthY = datePicker.year.toString()
//        var birthM = datePicker.month.toString()
//        var birthD = datePicker.dayOfMonth.toString()
//        var birth = "$birthY-$birthM-$birthD"

        profileSave_btn.setOnClickListener {
            // Implement Save Info action to Database
            Toast.makeText(this, "Your Information successfully saved", Toast.LENGTH_SHORT).show()
            finish()
        }

        profileBack_btn.setOnClickListener {
            finish()
        }
    }
}
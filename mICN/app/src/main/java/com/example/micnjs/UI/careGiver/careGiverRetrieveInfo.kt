package com.example.micnjs.UI.careGiver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.micnjs.R
import com.example.micnjs.UI.patient.patientContents
import kotlinx.android.synthetic.main.activity_care_giver_retrieve_info.*

class careGiverRetrieveInfo : AppCompatActivity() {
    //List of Servers 3개 -> 랜덤하게 콘텐츠 개수 보여주기
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_care_giver_retrieve_info)

        connectServer_btn.setOnClickListener {
            // Implement of Connecting with Server
            connectServer_tV.visibility = View.VISIBLE
            contents_btn.visibility = View.VISIBLE
        }

        moveBack_btn.setOnClickListener {
            finish()
        }

        contents_btn.setOnClickListener {
            val intent = Intent(this, careGiverContents::class.java)
            startActivity(intent)
        }
    }
}
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

        server1_btn.setOnClickListener {
            var intent = Intent(this, careGiverContents::class.java)
            startActivity(intent)
        }

        server2_btn.setOnClickListener {
            var intent = Intent(this, careGiverContents::class.java)
            startActivity(intent)
        }

        server3_btn.setOnClickListener {
            var intent = Intent(this, careGiverContents::class.java)
            startActivity(intent)
        }
    }
}
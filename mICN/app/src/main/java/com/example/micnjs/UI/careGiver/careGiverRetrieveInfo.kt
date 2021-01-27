package com.example.micnjs.UI.careGiver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.micnjs.R
import com.example.micnjs.UI.careGiver.contents.server1Contents
import com.example.micnjs.UI.careGiver.contents.server2Contents
import com.example.micnjs.UI.careGiver.contents.server3Contents
import kotlinx.android.synthetic.main.activity_care_giver_retrieve_info.*

class careGiverRetrieveInfo : AppCompatActivity() {
    //List of Servers 3개 -> 랜덤하게 콘텐츠 개수 보여주기
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_care_giver_retrieve_info)

        server1_btn.setOnClickListener {
            var intent = Intent(this, server1Contents::class.java)
            startActivity(intent)
        }

        server2_btn.setOnClickListener {
            var intent = Intent(this, server2Contents::class.java)
            startActivity(intent)
        }

        server3_btn.setOnClickListener {
            var intent = Intent(this, server3Contents::class.java)
            startActivity(intent)
        }

        moveBack_btn.setOnClickListener {
            finish()
        }
    }
}
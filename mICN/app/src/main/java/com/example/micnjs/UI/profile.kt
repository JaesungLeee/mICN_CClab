package com.example.micnjs.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.micnjs.R
import kotlinx.android.synthetic.main.activity_profile.*

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

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
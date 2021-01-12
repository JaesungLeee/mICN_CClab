package com.example.micnjs.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.micnjs.R
import kotlinx.android.synthetic.main.activity_emergency.*

class emergency : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        moveBack_btn.setOnClickListener {
            finish()
        }
    }
}
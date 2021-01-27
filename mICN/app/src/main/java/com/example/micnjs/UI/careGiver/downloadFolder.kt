package com.example.micnjs.UI.careGiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.micnjs.R
import kotlinx.android.synthetic.main.activity_download_folder.*

class downloadFolder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_folder)

        moveBack_btn.setOnClickListener {
            finish()
        }
    }
}
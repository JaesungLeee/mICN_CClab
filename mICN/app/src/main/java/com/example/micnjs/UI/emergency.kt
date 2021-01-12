package com.example.micnjs.UI

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.example.micnjs.R
import kotlinx.android.synthetic.main.activity_emergency.*
import java.lang.Exception

class emergency : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        moveBack_btn.setOnClickListener {
            finish()
        }

        callEmergency_btn.setOnClickListener {
            callEmergency()
        }
    }

    private fun callEmergency() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.setData(Uri.parse("tel:01028053454"))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(applicationContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                applicationContext.startActivity(intent)
            }
            else {
                Log.e("CALLEMERGENCY", "No Permission")
            }
        }
        else {
            applicationContext.startActivity(intent)
        }

    }
}
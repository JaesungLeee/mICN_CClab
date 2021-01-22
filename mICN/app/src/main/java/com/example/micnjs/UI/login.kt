package com.example.micnjs.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.micnjs.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth     // Firebase Authentication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()


        login_btn.setOnClickListener {
            var email = editEmail.text.toString()
            var password = editPW.text.toString()
            loginWithEmail(email, password)
        }

        signup_btn.setOnClickListener {
            var intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
    }

    private fun loginWithEmail(email : String, password :String) {
        auth!!.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    var intent = Intent(this, patientHome::class.java)
                    startActivity(intent)
                }
                else {
                    Log.e("ERROR", it.exception.toString())
                    Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show()
                }
            }
    }

}
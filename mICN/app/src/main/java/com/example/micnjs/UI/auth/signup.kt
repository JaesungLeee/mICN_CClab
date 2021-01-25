package com.example.micnjs.UI.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.micnjs.R
import com.example.micnjs.UI.careGiver.careGiverHome
import com.example.micnjs.UI.patient.patientHome
import com.example.micnjs.firebaseDB.careGiver
import com.example.micnjs.firebaseDB.patient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_signup.*

class signup : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth     // Firebase Authentication
    private val db = FirebaseDatabase.getInstance()

    var user = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()

        userType.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.userPatient) {
                Log.e("CHECKID", "Click patient")
                user = "Patient"
            }
            else if (checkedId == R.id.userCareGiver) {
                Log.e("CHECKID", "Click careGiver")
                user = "CareGiver"
            }
        }

        register_btn.setOnClickListener {
            var email = editEmail.text.toString()
            var password = editPW.text.toString()
            var confirmPassword = editCPW.text.toString()

            if (confirmPassword == password) {
                createUser(email, password, user)
            }
            else {
                Toast.makeText(this, "Check your password again", Toast.LENGTH_SHORT).show()
            }
        }

        goback_login_btn.setOnClickListener {
            var intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }

    private fun createUser(email: String, password: String, user: String) {
//        var birthY = datePicker.year.toString()
//        var birthM = datePicker.month.toString()
//        var birthD = datePicker.dayOfMonth.toString()
        var uid = ""  //auth.uid.toString()
        var name = editName.text.toString()
//        var birth = "$birthY-$birthM-$birthD"
        var birth = ""


        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    uid = auth.currentUser?.uid.toString()
                    Toast.makeText(this, "SignUp Successful", Toast.LENGTH_SHORT).show()

                    createDB(uid, name, email, password, birth, user)

                    Log.e("createUser", "Successful")
                }
                else {
                    Toast.makeText(this, "SignUp Failed", Toast.LENGTH_SHORT).show()
                    Log.e("createUser", "Failed" + task.exception)
                }
            }
    }

    fun createDB(uid: String, name: String, email: String, password: String, birth: String, user : String) {
        Log.e("CREATEDB", "cccc")
        if (user == "Patient") {
            db.reference.child("Patient").child(uid).setValue(
                patient(
                    uid,
                    name,
                    email,
                    password,
                    birth
                )
            )
        }
        else if (user == "CareGiver") {
            db.reference.child("CareGiver").child(uid).setValue(
                    careGiver(uid, name, email, password, birth)
            )
        }

        homePage(user)
    }

    fun homePage(user : String) {
        if (user == "Patient") {
            var intent = Intent(this, patientHome::class.java)
            startActivity(intent)
        }
        else if (user == "CareGiver") {
            var intent = Intent(this, careGiverHome::class.java)
            startActivity(intent)
        }
    }
}



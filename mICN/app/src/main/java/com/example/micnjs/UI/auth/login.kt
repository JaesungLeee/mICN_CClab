package com.example.micnjs.UI.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.micnjs.R
import com.example.micnjs.UI.careGiver.careGiverHome
import com.example.micnjs.UI.patient.patientHome
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {
    companion object {
        private var username = "USERNAME"
        private var userpw = "USERPW"
        private var userbirth = "USERBIRTH"
        private var useruid = "USERUID"
    }

    lateinit var auth : FirebaseAuth     // Firebase Authentication
    var databaseReference : DatabaseReference? = null
    var database : FirebaseDatabase? = null

    private var Flag : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Patient")

        val currentUser = auth.currentUser

        autoLogin(currentUser)

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
                    var currentUser = auth.currentUser
                    queryDB(currentUser)
                }
                else {
                    Log.e("ERROR", it.exception.toString())
                    Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun autoLogin(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            queryDB(currentUser)
        }
    }

    private fun queryDB(currentUser : FirebaseUser?) {
        val uid = currentUser?.uid!!
        val userReference = databaseReference?.child(uid)

        userReference?.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.child("userType").value.toString() == "Patient") {
                    val enterUserType = "Patient"
                    val name = snapshot.child("patientName").value.toString()
                    val password = snapshot.child("patientPW").value.toString()
                    val birth = snapshot.child("patientBirth").value.toString()

                    movePage(enterUserType, name, password, birth, uid)
                }
                else {
                    databaseReference = database?.reference!!.child("CareGiver")
                    queryDB(currentUser)
                    if (snapshot.child("userType").value.toString() == "CareGiver")


                    val enterUserType = "CareGiver"
                    movePage(enterUserType, name, password, birth, uid)
                }
            }

        })

    }

    private fun movePage(enterUserType : String, name: String, password: String, birth: String, uid: String) {
        if (enterUserType == "Patient") {
            var intent = Intent(this, patientHome::class.java).apply {
                putExtra(username, name)
                putExtra(userpw, password)
                putExtra(userbirth, birth)
                putExtra(useruid, uid)
            }
            startActivity(intent)
            finish()
        }
        else if (enterUserType == "CareGiver") {
            var intent = Intent(this, careGiverHome::class.java)
            startActivity(intent)
            finish()
        }
    }

}
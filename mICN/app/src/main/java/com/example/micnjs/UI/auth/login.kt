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
        private var USERUID = "USERUID"
        private var USERNICKNAME = "USERNICKNAME"
        private var USERFULLNAME = "USERFULLNAME"
        private var USEREMAIL = "USEREMAIL"
        private var USERPW = "USERPW"
        private var USERBIRTH = "USERBIRTH"
        private var USERTYPE = "USERTYPE"
    }

    lateinit var auth : FirebaseAuth     // Firebase Authentication
    var databaseReference : DatabaseReference? = null
    var database : FirebaseDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("User")

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
                    val nickName = snapshot.child("nickName").value.toString()
                    val password = snapshot.child("password").value.toString()
                    val birth = snapshot.child("birth").value.toString()
                    val fullName = snapshot.child("fullName").value.toString()
                    val email = snapshot.child("email").value.toString()

                    movePage(enterUserType, nickName, fullName, email, password, birth, uid)
                }
                else if (snapshot.child("userType").value.toString() == "CareGiver") {
                    val enterUserType = "CareGiver"
                    val nickName = snapshot.child("nickName").value.toString()
                    val password = snapshot.child("password").value.toString()
                    val birth = snapshot.child("birth").value.toString()
                    val fullName = snapshot.child("fullName").value.toString()
                    val email = snapshot.child("email").value.toString()

                    movePage(enterUserType, nickName, fullName, email, password, birth, uid)
                }
            }

        })

    }

    private fun movePage(enterUserType : String, nickName: String, fullName : String, email : String, password: String, birth: String, uid: String) {
        if (enterUserType == "Patient") {
            var intent = Intent(this, patientHome::class.java).apply {
                putExtra(USERUID, uid)
                putExtra(USERNICKNAME, nickName)
                putExtra(USERFULLNAME, fullName)
                putExtra(USEREMAIL, email)
                putExtra(USERPW, password)
                putExtra(USERBIRTH, birth)
                putExtra(USERTYPE, enterUserType)
            }
            startActivity(intent)
            finish()
        }
        else if (enterUserType == "CareGiver") {
            var intent = Intent(this, careGiverHome::class.java).apply {
                putExtra(USERUID, uid)
                putExtra(USERNICKNAME, nickName)
                putExtra(USERFULLNAME, fullName)
                putExtra(USEREMAIL, email)
                putExtra(USERPW, password)
                putExtra(USERBIRTH, birth)
                putExtra(USERTYPE, enterUserType)
            }
            startActivity(intent)
            finish()
        }
    }

}
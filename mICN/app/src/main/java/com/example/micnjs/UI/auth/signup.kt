package com.example.micnjs.UI.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.micnjs.R
import com.example.micnjs.UI.careGiver.careGiverHome
import com.example.micnjs.UI.patient.patientHome
import com.example.micnjs.firebaseDB.user
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_signup.*

class signup : AppCompatActivity() {

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
    var userType = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("User")


        userType_Group.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.userPatient) {
                Log.e("CHECKID", "Click patient")
                userType = "Patient"
            }
            else if (checkedId == R.id.userCareGiver) {
                Log.e("CHECKID", "Click careGiver")
                userType = "CareGiver"

            }
        }

        register_btn.setOnClickListener {
            var email = editEmail.text.toString()
            var password = editPW.text.toString()
            var confirmPassword = editCPW.text.toString()

            if (confirmPassword == password) {
                createUser(email, password, userType)
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

    private fun createUser(email: String, password: String, userType: String) {
        var uid = ""
        var nickName = editNickName.text.toString()
        var birth = ""
        var fullName = ""

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    uid = auth.currentUser?.uid.toString()

                    Toast.makeText(this, "SignUp Successful", Toast.LENGTH_SHORT).show()

                    createDB(uid, nickName, fullName, email, password, birth, userType)

                    Log.e("createUser", "Successful")
                }
                else {
                    Toast.makeText(this, "SignUp Failed", Toast.LENGTH_SHORT).show()
                    Log.e("createUser", "Failed" + task.exception)
                }
            }
    }

    private fun createDB(uid: String, nickName: String, fullName : String, email: String, password: String, birth: String, userType : String) {
        Log.e("CREATEDB", "cccc")

        if (userType == "Patient") {
            val currentUserDB = databaseReference?.child(uid)
            currentUserDB?.setValue(user(uid, nickName, fullName, email, password, birth, userType))

            Log.e("CHECK", "${uid}, ${nickName}, ${fullName}, ${email}, ${password}, ${birth}, ${userType}")
        }
        else if (userType == "CareGiver") {
            val currentUserDB = databaseReference?.child(uid)
            currentUserDB?.setValue(user(uid, nickName, fullName, email, password, birth, userType))

            Log.e("CHECK", "${uid}, ${nickName}, ${fullName}, ${email}, ${password}, ${birth}, ${userType}")
        }

        movePage(userType, uid, nickName, fullName, email, password, birth)
    }

    private fun movePage(userType: String, uid: String, nickName: String, fullName: String, email: String, password: String, birth: String) {
        if (userType == "Patient") {
            var intent = Intent(this, patientHome::class.java).apply {
                putExtra(USERUID, uid)
                putExtra(USERNICKNAME, nickName)
                putExtra(USERFULLNAME, fullName)
                putExtra(USEREMAIL, email)
                putExtra(USERPW, password)
                putExtra(USERBIRTH, birth)
                putExtra(USERTYPE, userType)
            }
            startActivity(intent)
        }
        else if (userType == "CareGiver") {
            var intent = Intent(this, careGiverHome::class.java).apply {
                putExtra(USERUID, uid)
                putExtra(USERNICKNAME, nickName)
                putExtra(USERFULLNAME, fullName)
                putExtra(USEREMAIL, email)
                putExtra(USERPW, password)
                putExtra(USERBIRTH, birth)
                putExtra(USERTYPE, userType)
            }
            startActivity(intent)
        }
    }
}



package com.example.micnjs.firebaseDB

class user(val uid : String, val nickName : String, val fulName : String, val email : String, val password : String, val birth : String, val userType : String) {
    constructor() : this("", "", "", "", "", "", "") {

    }
}
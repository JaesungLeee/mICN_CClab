package com.example.micnjs.firebaseDB

class patient(val patientUid : String, val patientName : String, val patientEmail : String, val patientPW : String, val patientBirth : String) {
    constructor() : this("", "", "", "", "") {

    }
}
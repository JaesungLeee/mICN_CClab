package com.example.micnjs

class patient(val patientUid : String, val patientName : String, val patientEmail : String, val patientPW : String, val patientBirth : String) {
    constructor() : this("", "", "", "", "") {

    }
}
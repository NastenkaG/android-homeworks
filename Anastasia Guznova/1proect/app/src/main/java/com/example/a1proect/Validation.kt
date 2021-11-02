package com.example.a1proect

class Validator {
    fun validateEmail(email: String): Boolean {
        if (!(email.contains("@")) and (email.length <= 6)) return true
        else return false
    }
    fun validatePassword(password: String): Boolean {
        if (password.length <= 7) return true
        else return false
    }
    fun validateIdenticalPassword(pass1: String, pass2: String): Boolean {
        if (pass1 != pass2) return true
        else return false
    }
}

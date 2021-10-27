package com.example.a1proect

class proverka {
    fun provEmail1(email: String) : Boolean{
        if(!(email.contains("@"))) return true
        else return false
    }
    fun provEmail2(email: String) : Boolean{
        if(email.length <= 6) return true
        else return false
    }

    fun provPassword(password: String) : Boolean{
        if(password.length <= 7) return true
        else return false
    }

    fun provPasswordRegistr(pass1: String, pass2: String) : Boolean{
        if(pass1 != pass2) return true
        else return false
    }


}
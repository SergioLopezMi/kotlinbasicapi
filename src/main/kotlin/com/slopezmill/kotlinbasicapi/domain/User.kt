package com.slopezmill.kotlinbasicapi.domain

class User(var id: Long? = null, var name: String = "", var surname: String = "", var professionalResume: ArrayList<Job> = arrayListOf())
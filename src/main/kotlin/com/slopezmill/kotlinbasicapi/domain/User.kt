package com.slopezmill.kotlinbasicapi.domain

data class User(var id: Long,
                var name: String,
                var surname: String,
                var professionalResume: ArrayList<Job>) {
    constructor() : this(-1, "", "", arrayListOf())
}
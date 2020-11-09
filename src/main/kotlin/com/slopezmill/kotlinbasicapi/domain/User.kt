package com.slopezmill.kotlinbasicapi.domain

import java.io.Serializable

data class User(var id: Long,
                var name: String,
                var surname: String,
                var professionalResume: ArrayList<Job>) : Serializable {
    constructor() : this(-1, "", "", arrayListOf())
}
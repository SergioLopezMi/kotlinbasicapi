package com.slopezmill.kotlinbasicapi.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.io.Serializable

@Document(collection = "Users")
data class User(
        @Id
        var id: String,
        @Field("name")
        var name: String,
        @Field("surname")
        var surname: String,
        @Field("professionalResume")
        var professionalResume: ArrayList<Job>) : Serializable {
    constructor() : this("", "", "", arrayListOf())
}
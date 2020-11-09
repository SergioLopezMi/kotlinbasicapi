package com.slopezmill.kotlinbasicapi.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.io.Serializable
import java.time.LocalDateTime

@Document("Job")
data class Job(@Id var id: Long,
               @Field("name") var name: String,
               @Field("initDate") var initDate: LocalDateTime,
               @Field("isEnded") var isEnded: Boolean,
               @Field("endDate") var endDate: LocalDateTime?) : Serializable {
    constructor() : this(-1, "", LocalDateTime.now(), false, null)
}
package com.slopezmill.kotlinbasicapi.domain

import java.io.Serializable
import java.time.LocalDateTime

data class Job(var id: Long,
               var name: String,
               var initDate: LocalDateTime,
               var isEnded: Boolean,
               var endDate: LocalDateTime?) : Serializable {
    constructor() : this(-1, "", LocalDateTime.now(), false, null)
}
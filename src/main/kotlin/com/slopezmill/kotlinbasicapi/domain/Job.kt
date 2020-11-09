package com.slopezmill.kotlinbasicapi.domain

import java.time.LocalDateTime

data class Job(var id: Long,
               var name: String,
               var initDate: LocalDateTime,
               var isEnded: Boolean,
               var endDate: LocalDateTime?) {
    constructor() : this(-1, "", LocalDateTime.now(), false, null)
}
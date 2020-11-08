package com.slopezmill.kotlinbasicapi.domain

import java.time.LocalDateTime

class Job (var id: Long, var name: String, var initDate: LocalDateTime, var isEnded: Boolean, var endDate: LocalDateTime?) {
}
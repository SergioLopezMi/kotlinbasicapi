package com.slopezmill.kotlinbasicapi.dto

import java.time.LocalDateTime

class JobDto(var id: Long, var name: String, var initDate: LocalDateTime, var isEnded: Boolean, var endDate: LocalDateTime?)
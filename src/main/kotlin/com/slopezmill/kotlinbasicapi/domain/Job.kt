package com.slopezmill.kotlinbasicapi.domain

import java.time.LocalDateTime

class Job(var id: Long? = null, var name: String = "", var initDate: LocalDateTime? = null, var isEnded: Boolean = false, var endDate: LocalDateTime? = null)
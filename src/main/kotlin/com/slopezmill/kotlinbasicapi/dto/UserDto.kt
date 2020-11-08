package com.slopezmill.kotlinbasicapi.dto

import com.slopezmill.kotlinbasicapi.domain.Job

class UserDto(var id: Long, var name: String, var surname: String, var professionalResume: ArrayList<Job> = arrayListOf())
package com.slopezmill.kotlinbasicapi.dto

import com.slopezmill.kotlinbasicapi.domain.Job
import java.io.Serializable

class UserDto(var id: String,
              var name: String,
              var surname: String,
              var professionalResume: ArrayList<Job> = arrayListOf()) : Serializable
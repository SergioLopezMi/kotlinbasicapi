package com.slopezmill.kotlinbasicapi.service

import com.slopezmill.kotlinbasicapi.domain.User

interface UserService {
    fun addUser(): ArrayList<User>
}
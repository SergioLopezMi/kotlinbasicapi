package com.slopezmill.kotlinbasicapi.controller

import com.slopezmill.kotlinbasicapi.domain.User
import com.slopezmill.kotlinbasicapi.dto.JobDto
import com.slopezmill.kotlinbasicapi.dto.UserDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody


interface UserController {
    fun findAllUsers(): ResponseEntity<List<User>>
    fun findUserById(@PathVariable id: Int): ResponseEntity<User>
    fun addUser(@RequestBody userDto: UserDto): ResponseEntity<User>
    fun addJob(@PathVariable id: Int, @RequestBody jobDto: JobDto): ResponseEntity<User>
}
package com.slopezmill.kotlinbasicapi.controller

import com.slopezmill.kotlinbasicapi.domain.User
import com.slopezmill.kotlinbasicapi.dto.JobDto
import com.slopezmill.kotlinbasicapi.dto.UserDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import java.util.*


interface UserController {
    fun findAllUsers(): ResponseEntity<List<User>>
    fun findUserById(@PathVariable id: String): ResponseEntity<Optional<User>>
    fun addUser(@RequestBody userDto: UserDto): ResponseEntity<Optional<User>>
    fun addJob(@PathVariable id: String, @RequestBody jobDto: JobDto): ResponseEntity<User>
    fun updateUser(@PathVariable id: String, @RequestBody userDto: UserDto): ResponseEntity<User>

    // fun updateUserJob(@PathVariable userId: String, @RequestBody jobDto: JobDto): ResponseEntity<User>

    fun deleteUser(@PathVariable id: String): Boolean

    // fun deleteUserJob(@PathVariable userId: String, @RequestBody jobDto: JobDto): Boolean
}
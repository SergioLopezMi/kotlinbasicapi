package com.slopezmill.kotlinbasicapi.mapper

import com.slopezmill.kotlinbasicapi.domain.User
import com.slopezmill.kotlinbasicapi.dto.UserDto
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun map(userDto: UserDto): User {
        val user = User()

        user.id = userDto.id
        user.name = userDto.name
        user.surname = userDto.surname
        user.professionalResume = userDto.professionalResume

        return user
    }
}
package com.slopezmill.kotlinbasicapi.mapper

import com.slopezmill.kotlinbasicapi.domain.User
import com.slopezmill.kotlinbasicapi.dto.UserDto
import org.springframework.stereotype.Component
import java.util.*

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

    fun map(userDto: Optional<User>): User {
        val user = User()

        user.id = userDto.get().id
        user.name = userDto.get().name
        user.surname = userDto.get().surname
        user.professionalResume = userDto.get().professionalResume

        return user
    }
}
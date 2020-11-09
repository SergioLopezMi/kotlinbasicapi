package com.slopezmill.kotlinbasicapi.repository

import com.slopezmill.kotlinbasicapi.domain.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, Long> {
}
package com.slopezmill.kotlinbasicapi.repository

import com.slopezmill.kotlinbasicapi.domain.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : MongoRepository<User, String> {

}
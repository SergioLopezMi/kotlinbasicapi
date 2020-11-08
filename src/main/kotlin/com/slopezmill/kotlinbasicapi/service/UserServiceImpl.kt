package com.slopezmill.kotlinbasicapi.service

import com.slopezmill.kotlinbasicapi.domain.Job
import com.slopezmill.kotlinbasicapi.domain.User
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserServiceImpl : UserService {
    private var listUser: ArrayList<User> = arrayListOf()

    override fun addUser(): ArrayList<User> {
        val user = User()
        val user2 = User()
        val job = Job()
        val job2 = Job()

        user.id = 1
        user.name = "Sergio"
        user.surname = "López"
        // Se añaden los trabajos
        job.id = 1
        job.name = "Camarero"
        job.initDate = LocalDateTime.of(2015, 6, 20, 10, 10)
        job.isEnded = true
        job.endDate = LocalDateTime.of(2019, 6, 20, 10, 10)

        job2.id = 2
        job2.name = "Desarrollador"
        job2.initDate = LocalDateTime.of(2019, 7, 20, 10, 10)
        job2.isEnded = false

        user.professionalResume.add(job)
        user.professionalResume.add(job2)

        user2.id = 2
        user2.name = "Ángela"
        user2.surname = "Cases"

        listUser.add(user)
        listUser.add(user2)

        return listUser
    }
}
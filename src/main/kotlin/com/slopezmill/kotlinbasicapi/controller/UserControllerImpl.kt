package com.slopezmill.kotlinbasicapi.controller


import com.slopezmill.kotlinbasicapi.domain.Job
import com.slopezmill.kotlinbasicapi.domain.User
import com.slopezmill.kotlinbasicapi.dto.JobDto
import com.slopezmill.kotlinbasicapi.dto.UserDto
import com.slopezmill.kotlinbasicapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserControllerImpl(@Autowired userService: UserService) : UserController {

    private var listUser: ArrayList<User> = userService.addUser()

    @GetMapping
    override fun findAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity(listUser, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    override fun findUserById(@PathVariable id: Int): ResponseEntity<User> {
        return ResponseEntity(listUser[(id - 1)], HttpStatus.OK)
    }

    @PostMapping(consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    override fun addUser(@RequestBody userDto: UserDto): ResponseEntity<User> {
        val user = User()

        user.id = userDto.id
        user.name = userDto.name
        user.surname = userDto.surname

        listUser.add(user)
        return ResponseEntity(user, HttpStatus.OK)
    }

    @PostMapping(value = arrayOf("/{id}"), consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    override fun addJob(id: Int, jobDto: JobDto): ResponseEntity<User> {
        val job = Job()

        job.id = jobDto.id
        job.name = jobDto.name
        job.initDate = jobDto.initDate
        job.isEnded = jobDto.isEnded
        job.endDate = jobDto.endDate

        listUser[(id-1)].professionalResume.add(job)

        return ResponseEntity(listUser[(id-1)], HttpStatus.OK)
    }

    //TODO: Put y Delete para user y job
}

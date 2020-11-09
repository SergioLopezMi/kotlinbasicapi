package com.slopezmill.kotlinbasicapi.controller


import com.slopezmill.kotlinbasicapi.domain.User
import com.slopezmill.kotlinbasicapi.dto.JobDto
import com.slopezmill.kotlinbasicapi.dto.UserDto
import com.slopezmill.kotlinbasicapi.mapper.JobMapper
import com.slopezmill.kotlinbasicapi.mapper.UserMapper
import com.slopezmill.kotlinbasicapi.repository.UserRepository
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/user")
class UserControllerImpl @Autowired constructor(
        private val userMapper: UserMapper,
        private val jobMapper: JobMapper,
        private val userRepository: UserRepository) : UserController {

    private val LOG = LogManager.getLogger()
    //private var listUser: ArrayList<User> = userService.addUser()

    //TODO: Comprobar por qué da error al cargar el repositorio
    @GetMapping
    override fun findAllUsers(): ResponseEntity<List<User>> {
        LOG.info("Find all users")
        return ResponseEntity(userRepository.findAll(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    override fun findUserById(@PathVariable id: String): ResponseEntity<Optional<User>> {
        LOG.info("Find user with id $id")
        return ResponseEntity(userRepository.findById(id), HttpStatus.OK)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    override fun addUser(@RequestBody userDto: UserDto): ResponseEntity<Optional<User>> {
        LOG.info("New user added")

        val user = userMapper.map(userDto)

        // listUser.add(user)
        userRepository.save(user)
        return ResponseEntity(userRepository.findById(user.id), HttpStatus.OK)
    }

    @PostMapping("/{id}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    override fun addJob(id: String, jobDto: JobDto): ResponseEntity<User> {
        LOG.info("Update professional resume user with id $id")

        val job = jobMapper.map(jobDto)
        val userDto = userRepository.findById(id)
        var user = userMapper.map(userDto)

        return ResponseEntity(userRepository.save(user), HttpStatus.OK)
    }

    @PutMapping("/{id}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    override fun updateUser(id: String, userDto: UserDto): ResponseEntity<User> {
        LOG.info("Update user with id $id")

        val user = userMapper.map(userDto)
        userRepository.save(user)

        return ResponseEntity(userRepository.save(user), HttpStatus.OK)
    }

    /* @PutMapping("/job/{userId}", consumes = [MediaType.APPLICATION_JSON_VALUE])
     override fun updateUserJob(userId: String, jobDto: JobDto): ResponseEntity<User> {
         LOG.info("Update user job with user id $userId")

         *//* if (jobDto.id != null && !jobDto.name.isNullOrEmpty() && jobDto.initDate != null && jobDto.isEnded != null) {
             val user = listUser[userId - 1]
             val job = jobMapper.map(jobDto)
             user.professionalResume[jobDto.id.toInt() - 1] = job
         }*//*
        val userDto = userRepository.findById(userId)
        val job = jobMapper.map(jobDto)
        var user = userMapper.map(userDto)

        user.professionalResume = userRepository.findById(userId).

                for (var userJob in user.professionalResume) {
                    if (userJob.id == job.id) {
                        user.professionalResume.remove = jobMapper.map(jobDto)
                    }
                }

        return ResponseEntity(listUser[userId - 1], HttpStatus.OK)
    }*/

    @DeleteMapping("/{id}")
    override fun deleteUser(@PathVariable id: String): Boolean {
        LOG.info("Delete user with id $id")
        var deleted: Boolean
        return try {
            userRepository.deleteById(id)
            true
        } catch (ex: IllegalArgumentException) {
            LOG.error("${ex.message} ${ex.cause}")
            false
        }

    }

    /*@DeleteMapping("/{userId}/job")
    override fun deleteUserJob(@PathVariable userId: String, @RequestBody jobDto: JobDto): Boolean {
        LOG.info(("Delete user's id $userId job ${jobDto.id}"))

        for (user in listUser) {
            if (user.id == userId) {
                for (job in user.professionalResume) {
                    if (job.id == jobDto.id) {
                        return user.professionalResume.remove(job)
                    }
                }
            }
        }
        return false
    }*/
}
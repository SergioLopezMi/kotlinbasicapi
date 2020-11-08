package com.slopezmill.kotlinbasicapi.controller


import com.slopezmill.kotlinbasicapi.domain.Job
import com.slopezmill.kotlinbasicapi.domain.User
import com.slopezmill.kotlinbasicapi.dto.JobDto
import com.slopezmill.kotlinbasicapi.dto.UserDto
import com.slopezmill.kotlinbasicapi.service.UserService
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.jws.soap.SOAPBinding

@RestController
@RequestMapping("/user")
class UserControllerImpl(@Autowired userService: UserService) : UserController {

    private val LOG = LogManager.getLogger()
    private var listUser: ArrayList<User> = userService.addUser()

    @GetMapping
    override fun findAllUsers(): ResponseEntity<List<User>> {
        LOG.info("Find all users")
        return ResponseEntity(listUser, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    override fun findUserById(@PathVariable id: Int): ResponseEntity<User> {
        LOG.info("Find user with id $id")
        return ResponseEntity(listUser[(id - 1)], HttpStatus.OK)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    override fun addUser(@RequestBody userDto: UserDto): ResponseEntity<User> {
        LOG.info("New user added")

        val user = User()

        user.id = userDto.id
        user.name = userDto.name
        user.surname = userDto.surname

        listUser.add(user)
        return ResponseEntity(user, HttpStatus.OK)
    }

    @PostMapping("/{id}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    override fun addJob(id: Int, jobDto: JobDto): ResponseEntity<User> {
        LOG.info("Update professional resume user with id $id")

        val job = Job()

        job.id = jobDto.id
        job.name = jobDto.name
        job.initDate = jobDto.initDate
        job.isEnded = jobDto.isEnded
        job.endDate = jobDto.endDate

        listUser[(id - 1)].professionalResume.add(job)

        return ResponseEntity(listUser[(id - 1)], HttpStatus.OK)
    }

    @PutMapping("/{id}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    override fun updateUser(id: Int, userDto: UserDto): ResponseEntity<User> {
        LOG.info("Update user with id $id")

        var user = User()

        if (!userDto.name.isNullOrEmpty() && !userDto.surname.isNullOrEmpty()) {
            user = listUser[id - 1]
            user.name = userDto.name
            user.surname = userDto.surname
            listUser[id - 1] = user
        }

        return ResponseEntity(listUser.elementAt((id - 1)), HttpStatus.OK)
    }

    @PutMapping("/job/{userId}", consumes = [MediaType.APPLICATION_JSON_VALUE])
    override fun updateUserJob(userId: Int, jobDto: JobDto): ResponseEntity<User> {
        LOG.info("Update user job with user id $userId")

        var user: User
        var job = Job()

        if (jobDto.id != null && !jobDto.name.isNullOrEmpty() && jobDto.initDate != null && jobDto.isEnded != null) {
            user = listUser[userId - 1]
            job = user.professionalResume[jobDto.id.toInt() - 1]

            job.name = jobDto.name
            job.initDate = jobDto.initDate
            job.isEnded = jobDto.isEnded
            job.endDate = jobDto.endDate

            user.professionalResume[jobDto.id.toInt() - 1] = job
        }
        return ResponseEntity(listUser[userId - 1], HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    override fun deleteUser(@PathVariable id: Int): Boolean {
        LOG.info("Delete user with id $id")

        for (user in listUser) {
            if(user.id == id.toLong()){
                return listUser.remove(user)
            }
        }

        return false
    }

    @DeleteMapping("/{userId}/job")
    override fun deleteUserJob(@PathVariable userId: Int, @RequestBody jobDto: JobDto): Boolean {
        LOG.info(("Delete user's id $userId job ${jobDto.id}"))

        for(user in listUser){
            if(user.id == userId.toLong()){
                for(job in user.professionalResume){
                    if(job.id == jobDto.id){
                        return user.professionalResume.remove(job)
                    }
                }
            }
        }
        return false
    } //TODO: Put y Delete para user y job
}
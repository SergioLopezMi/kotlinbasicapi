package com.slopezmill.kotlinbasicapi.mapper

import com.slopezmill.kotlinbasicapi.domain.Job
import com.slopezmill.kotlinbasicapi.dto.JobDto
import org.springframework.stereotype.Component

@Component
class JobMapper {
    fun map(jobDto: JobDto): Job {
        var job = Job()

        job.id = jobDto.id
        job.name = jobDto.name
        job.initDate = jobDto.initDate
        job.isEnded = jobDto.isEnded
        job.endDate = jobDto.endDate

        return job
    }
}
package com.udemy.docker.dockerapp.controller

import com.udemy.docker.dockerapp.VisitRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/api/visit")
class HelloController(private val visitRepository: VisitRepository) {

    @GetMapping("/counter")
    fun updateCounter() = visitRepository.updateCounter()
}
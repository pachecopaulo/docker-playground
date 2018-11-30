package com.poc.docker.app.controller

import com.poc.docker.app.repository.VisitRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/visits")
class CounterController(private val visitRepository: VisitRepository) {

    @GetMapping("/counter")
    fun updateCounter() =
        "number of visits: ${visitRepository.updateVisits()}"
}
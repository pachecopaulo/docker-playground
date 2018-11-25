package com.udemy.docker.dockerapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DockerAppApplication

fun main(args: Array<String>) {
    runApplication<DockerAppApplication>(*args)
}

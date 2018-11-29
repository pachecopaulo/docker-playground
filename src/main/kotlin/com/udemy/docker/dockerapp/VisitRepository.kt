package com.udemy.docker.dockerapp

import org.springframework.data.redis.core.HashOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository
import javax.annotation.PostConstruct

@Repository
class VisitRepository {

    private val redisTemplate = RedisTemplate<String, Object>()
    private lateinit var hashOperations: HashOperations<String, String, Long>

    @PostConstruct
    fun init() {
        hashOperations = redisTemplate.opsForHash()
    }

    fun updateCounter() {
        val lastCount = hashOperations.get(VISIT_KEY, "counter") ?: 1
        hashOperations.put(VISIT_KEY, "counter", lastCount)
    }

    companion object {
        const val VISIT_KEY = "Visit"
    }
}
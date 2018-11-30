package com.poc.docker.app.repository

import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Repository

@Repository
class VisitRepository(private val stringRedisTemplate: StringRedisTemplate) {

    fun updateVisits(): Long {
        val visitCount = stringRedisTemplate.opsForValue().get(KEY)
            ?.toLong()
            ?.let { it + 1 }
            ?: 1
        stringRedisTemplate.opsForValue().set(KEY, visitCount.toString())
        return visitCount
    }

    companion object {
        const val KEY = "VisitKey"
    }
}
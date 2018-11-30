package com.poc.docker.app.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisConfig {

    @Bean
    fun redisConnectionFactory() = LettuceConnectionFactory()

    @Bean
    fun redisTemplate() =
        RedisTemplate<String, Long>().apply {
            setConnectionFactory(redisConnectionFactory())
        }
}
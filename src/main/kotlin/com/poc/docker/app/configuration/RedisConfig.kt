package com.poc.docker.app.configuration

import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisConfig {

    @Bean
    fun redisConnectionFactory() = LettuceConnectionFactory(
        RedisStandaloneConfiguration().apply {
            hostName = redisProperties().host
            port = redisProperties().port
        }
    )

    @Bean
    fun redisTemplate() =
        RedisTemplate<String, Long>().apply {
            setConnectionFactory(redisConnectionFactory())
        }

    @Bean
    @Primary
    fun redisProperties() = RedisProperties()
}
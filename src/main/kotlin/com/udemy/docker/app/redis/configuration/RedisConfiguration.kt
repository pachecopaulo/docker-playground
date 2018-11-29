package com.udemy.docker.app.redis.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
@EnableCaching
class RedisConfiguration {

    @Bean
    fun redisConnectionFactory() =
        JedisConnectionFactory(
            RedisStandaloneConfiguration().apply {
                hostName = "localhost"
                password = RedisPassword.of("1234")
                port = 1111
            }
        )

    @Bean
    fun redisTemplate(@Autowired redisConnectionFactory: RedisConnectionFactory) =
        RedisTemplate<String, Set<String>>()
            .apply { setConnectionFactory(redisConnectionFactory) }
}
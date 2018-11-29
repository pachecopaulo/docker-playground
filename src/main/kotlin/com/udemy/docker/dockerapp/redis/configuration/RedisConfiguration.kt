package com.udemy.docker.dockerapp.redis.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericToStringSerializer

@Configuration
class RedisConfiguration {

    @Bean
    fun jedisConnectionFactory() = JedisConnectionFactory()

    @Bean
    fun redisTemplate() =
        RedisTemplate<String, Object>().apply {
            setConnectionFactory(connectionFactory!!)
            valueSerializer = GenericToStringSerializer<Object>(Object::class.java)
        }
}
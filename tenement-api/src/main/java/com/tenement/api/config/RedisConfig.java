package com.tenement.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

/**
 * @author 徐周
 * @date ：Created in 2020-07-13 11:28
 * @description：redis分布式琐
 * @version: 1
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisLockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory) {
        return new RedisLockRegistry(redisConnectionFactory, "REDIS_LOCK");
    }
}

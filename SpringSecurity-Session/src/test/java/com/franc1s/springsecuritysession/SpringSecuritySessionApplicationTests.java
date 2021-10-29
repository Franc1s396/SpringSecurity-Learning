package com.franc1s.springsecuritysession;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringSecuritySessionApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    void contextLoads() {
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        RedisConnection connection = connectionFactory.getConnection();
        System.out.println(connection.ping());
    }

}

package com.test;


import com.enjoy.RedisMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@SpringBootTest(classes = RedisMain.class)
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void testRedisTemplate() {
       // redisTemplate.opsForValue().set("pig", "red");
        System.out.println(redisTemplate.opsForValue().get("pig"));
    }

    @Test
    public void testStringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("newYear", "oleYear");
        System.out.println(stringRedisTemplate.opsForValue().get("newYear"));
    }
}

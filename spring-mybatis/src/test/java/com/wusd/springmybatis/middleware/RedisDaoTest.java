package com.wusd.springmybatis.middleware;

import com.wusd.springmybatis.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@Slf4j
public class RedisDaoTest extends BaseTest {
    @Autowired
    RedisDao redisDao;

    @Test
    public void setKey() {
    }

    @Test
    public void getValue() {
        redisDao.setKey("name", "wusd");
        redisDao.setKey("age", "26");
        String name = redisDao.getValue("name");
        String age = redisDao.getValue("age");
        log.info("name->{}", name);
        log.info("age->{}", age);
    }
}
package com.wusd.springmybatis.dao;

import com.wusd.springmybatis.SpringMybatisApplicationTests;
import com.wusd.springmybatis.model.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

public class AccountMapperTest extends SpringMybatisApplicationTests {

    @Autowired
    AccountMapper accountMapper;

    @Test
    public void test() {
        Account account = accountMapper.selectByPrimaryKey(2);
        System.out.println();
    }
}
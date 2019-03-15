package com.wusd.springmybatis.service;

import com.wusd.springmybatis.dao.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * SpringBoot开启事务很简单, 只需要一个注解@Transactional
 * 前提是用了jdbctemplate, jpa, mybatis这种常见的orm
 */
@Service
public class AccountService2 {
    @Autowired
    AccountService accountService;

    @Transactional
    public void transfer() throws RuntimeException {
        accountService.update("wusx", 11, 1);
        int i = 1/0;
        accountService.update("wusxxx", 11, 1);
    }
}

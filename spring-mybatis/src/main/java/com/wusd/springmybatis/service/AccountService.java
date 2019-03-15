package com.wusd.springmybatis.service;

import com.wusd.springmybatis.dao.AccountMapper;
import com.wusd.springmybatis.model.Account;
import com.wusd.springmybatis.model.AccountExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    public int add(String name, double money) {
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);
        return accountMapper.insert(account);
    }

    public int update(String name, double money, int id) {
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);
        account.setId(id);
        return accountMapper.updateByPrimaryKey(account);
    }

    public int delete(int id) {
        return accountMapper.deleteByPrimaryKey(id);
    }

    public Account findAccount(int id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    public List<Account> findAccountList(AccountExample example) {
        return accountMapper.selectByExample(example);
    }

}

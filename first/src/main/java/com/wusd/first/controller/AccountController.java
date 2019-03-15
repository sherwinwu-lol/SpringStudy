package com.wusd.first.controller;

import com.wusd.first.dao.AccountDao;
import com.wusd.first.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountDao accountDao;

    @GetMapping(value = "/list")
    public List<Account> getAccounts() {
        return accountDao.findAll();
    }

    @GetMapping(value = "/{id}")
    public Account getAccountId(@PathVariable("id") int id) {
        return accountDao.findById(id).orElse(null);
    }

    @PutMapping(value = "/{id}")
    public String updateAccount(@PathVariable("id") int id,
                                @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        Account account1 = accountDao.saveAndFlush(account);

        return account1.toString();
    }

    @PostMapping(value = "")
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        Account account1 = accountDao.save(account);
        return account1.toString();
    }
}

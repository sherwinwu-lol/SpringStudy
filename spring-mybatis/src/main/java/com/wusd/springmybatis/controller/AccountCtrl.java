package com.wusd.springmybatis.controller;

import com.wusd.springmybatis.model.Account;
import com.wusd.springmybatis.model.AccountExample;
import com.wusd.springmybatis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountCtrl {
    @Autowired
    AccountService accountService;

    @GetMapping("/list")
    public List<Account> getAccounts() {
        AccountExample accountExample = new AccountExample();
        return accountService.findAccountList(accountExample);
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccount(id);
    }

    @PutMapping("/{id}")
    public String updateAccount(@PathVariable("id") int id,
                                @RequestParam(value = "name") String name,
                                @RequestParam(value = "money") double money) {
        int t = accountService.update(name, money, id);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        int t = accountService.delete(id);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @PostMapping("")
    public String postAccount(@RequestParam("name") String name,
                              @RequestParam("money") double money) {
        int t = accountService.add(name, money);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }
    }
}

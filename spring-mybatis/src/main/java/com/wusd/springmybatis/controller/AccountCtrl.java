package com.wusd.springmybatis.controller;

import com.github.pagehelper.PageHelper;
import com.wusd.springmybatis.model.Account;
import com.wusd.springmybatis.model.AccountExample;
import com.wusd.springmybatis.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("账单管理")
@RestController
@RequestMapping("/account")
public class AccountCtrl {
    @Autowired
    AccountService accountService;

    @ApiOperation("账单列表分页")
    @GetMapping("/list/{pageNo}/{pageSize}")
    public List<Account> getAccounts(@PathVariable("pageNo") int pageNo,
                                     @PathVariable("pageSize") int pageSize) {
        AccountExample accountExample = new AccountExample();
        PageHelper.startPage(pageNo, pageSize);
        // 这个查询会分页
        List<Account> accountList = accountService.findAccountList(accountExample);
//        return accountList;
        // 这个查询不会分页
        return accountService.findAccountList(accountExample);
    }

    @ApiOperation("根据id获取账单")
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccount(id);
    }

    @ApiOperation("根据id修改账单")
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

    @ApiOperation("根据id删除账单")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        int t = accountService.delete(id);
        if (t == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @ApiOperation("增加账单")
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

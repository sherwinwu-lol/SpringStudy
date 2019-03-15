package com.wusd.first.controller;

import com.wusd.first.bean.ConfigBean;
import com.wusd.first.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 另外需要在应用类或者application类, 加EnableConfigurationProperties注解.
// 可加可不加
@EnableConfigurationProperties({ConfigBean.class, User.class})
public class LucyController {
    @Autowired
    ConfigBean configBean;

    @Autowired
    User user;

    @GetMapping(value = "/lucy")
    public String lucy() {
        return configBean.getGreeting() + " >>>>" + configBean.getName() + " >>>>" + configBean.getUuid()
                + " >>>>" + configBean.getMax();
    }

    @GetMapping(value = "/user")
    public String user() {
        return user.getName() + user.getAge();
    }
}

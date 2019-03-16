package com.wusd.springmybatis;

import com.wusd.springmybatis.middleware.CustomerRepository;
import com.wusd.springmybatis.model.Account;
import com.wusd.springmybatis.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
// 这个注解对应了项目中mapper(dao)所对应的包路径
@MapperScan("com.wusd.springmybatis.dao")
public class SpringMybatisApplication implements CommandLineRunner {
    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        repository.findAll().stream().forEach(System.out::println);
        log.info("Customers found with findByFirstName('Alice'):");
        log.info("----------------------------------------------");
        log.info("{}", repository.findByFirstName("Alice"));

        log.info("Customers found with findByLastName('Smith'):");
        log.info("----------------------------------------------");
        repository.findByLastName("Smith").stream().forEach(System.out::println);
    }
}

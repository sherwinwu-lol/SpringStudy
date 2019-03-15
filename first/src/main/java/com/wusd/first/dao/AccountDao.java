package com.wusd.first.dao;

import com.wusd.first.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

// 数据访问层, 通过编写一个继承自JpaRepository的接口就能完成数据访问, 其中包含了基本的单表查询方法
// 注意: account对象名, 不是具体的表名, Integer是主键的类型, 一般为Integer或者long
public interface AccountDao extends JpaRepository<Account, Integer> {
}

package com.wusd.design.first.comboReuse.ref;

public class CustomerDAO {
    DBUtil util;

    void addCustomer() {
        // 改为oracleDBUtil只需要将oracleDBUtil注入, 里氏替换原则
        util.getConnection();
    }
}

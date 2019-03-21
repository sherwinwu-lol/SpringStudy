package com.wusd.design.first.relyReverse.old;

public class CustomerDAO {
    void addCustomers() {
//        ExcelDataConvertor convertor = new ExcelDataConvertor();
        TXTDataConvertor convertor = new TXTDataConvertor();
        convertor.readFile();
    }
}

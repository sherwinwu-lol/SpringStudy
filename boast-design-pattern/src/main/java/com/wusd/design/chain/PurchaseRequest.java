package com.wusd.design.chain;

import lombok.Data;

//采购单:请求类
@Data
public class PurchaseRequest {
    //采购金额
    private double amount;
    //采购单编号
    private int number;
    //采购目的
    private String purpose;

    public PurchaseRequest(double amount, int number, String purpose) {
        this.amount = amount;
        this.number = number;
        this.purpose = purpose;
    }
}

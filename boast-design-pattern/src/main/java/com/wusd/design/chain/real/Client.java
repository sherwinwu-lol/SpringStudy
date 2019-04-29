package com.wusd.design.chain.real;

public class Client {
    public static void main(String[] args) {
        Approver wjzhang, gyang, meeting;
        wjzhang = new Director("张无忌");
        gyang = new VicePresident("杨过");
        meeting = new President("郭靖");

        wjzhang.setSuccessor(gyang);
        gyang.setSuccessor(meeting);

        //创建采购单
        PurchaseRequest pr1 = new PurchaseRequest(45000, 10001, "购买倚天剑");
        wjzhang.processRequest(pr1);

        PurchaseRequest pr2 = new PurchaseRequest(60000, 10002, "购买屠龙刀");
        wjzhang.processRequest(pr2);
    }
}

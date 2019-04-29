package com.wusd.design.chain.ref;

/**
 * 具体处理者是抽象处理者的子类,它具有两大作用:第一是处理请求,不同的具体处理者以不同的形式实现抽象请求处理方法handRequest();
 * 第二是转发请求,如果该请求超出了当前处理者类的权限,可以将该请求转发给下家.
 */
public class ConcreteHandler extends Handler {
    @Override
    public void handleRequest(String request) {
        if (true) {
            //处理请求
        }
        else {
            //转发请求
            this.successor.handleRequest(request);
        }
    }
}
/**
 * 责任链模式并不创建责任链,责任链的创建工作必须由系统的其他部分来完成,一般是在使用责任链的客户端创建责任链.
 * 责任链模式降低了请求的发送端和接收端之间的耦合,使多个对象都有机会处理这个请求.
 */

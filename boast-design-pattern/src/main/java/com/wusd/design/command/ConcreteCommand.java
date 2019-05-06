package com.wusd.design.command;

/**
 * 具体命令类:
 * 是吸纳了在抽象命令类中声明的方法,它对应具体的接收者对象,
 * 将接收者对象的动作绑定其中.在实现execute()方法时,将调用接收者对象的相关action操作
 */
public class ConcreteCommand extends Command {
    //维持一个对请求接收者对象的引用
    private Receiver receiver;
    @Override
    public void execute() {
        //调用请求接收者的业务处理方法action()
        receiver.action();
    }
}

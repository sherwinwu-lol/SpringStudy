package com.wusd.design.command;

/**
 * 抽象命令类:
 * 抽象命令类一般是一个抽象类或接口,在其中声明了用于执行请求的execute()等方法,
 * 通过这些方法可以调用接收者的相关操作
 */
public abstract class Command {
    public abstract void execute();
}

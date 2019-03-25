package com.wusd.design.third;

public class TaskManager {
    /**
     * TaskManager内部创建对象
     */
    private static TaskManager tm = null;
    /**
     * 由于每次使用new实例化TaskManager类将产生新对象, 改为private
     */
    private TaskManager() {

    }

    /**
     * 为了保证成员变量的封装性, 将构造器设置为private, 外界通过公共方法访问这个实例
     */
    public static TaskManager getInstance() {
        if (tm == null) {
            tm = new TaskManager();
        }
        return tm;
    }

    /**
     * 显示进程
     */
    public void displayProcesses() {

    }

    // 显示服务
    public void displayServices() {

    }
}

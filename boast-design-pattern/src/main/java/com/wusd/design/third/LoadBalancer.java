package com.wusd.design.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadBalancer {
    //私有静态成员变量, 存储唯一实例
    private static LoadBalancer instance = null;
    //服务器集合
    List<String> serverList = new ArrayList<>();
    //私有构造函数
    private LoadBalancer() {

    }

    //公有静态成员方法,返回唯一实例
    public static LoadBalancer getInstance() {
        if (instance == null) {
            instance = new LoadBalancer();
        }
        return instance;
    }

    //删除服务器
    public void addServer(String sever) {
        serverList.add(sever);
    }

    //使用Random类随机获取服务器
    public void removeServer(String server) {
        serverList.remove(server);
    }

    public String getServer() {
        Random rand = new Random();
        int randInt = rand.nextInt(serverList.size());
        return serverList.get(randInt);
    }
}

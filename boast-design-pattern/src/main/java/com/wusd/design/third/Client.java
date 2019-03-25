package com.wusd.design.third;

public class Client {
    public static void main(String[] args) {
        LoadBalancer balancer1, balancer2, balancer3, balancer4;
        balancer1 = LoadBalancer.getInstance();
        balancer2 = LoadBalancer.getInstance();
        balancer3 = LoadBalancer.getInstance();
        balancer4 = LoadBalancer.getInstance();

        if (balancer1 == balancer2 && balancer2 == balancer3 && balancer3 == balancer4){
            System.out.println("服务器负载均衡器具有唯一性!");
        }
    }
}

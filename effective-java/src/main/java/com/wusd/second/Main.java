package com.wusd.second;

import org.joda.time.DateTime;

public class Main {
    /**
     * 类提供一个公有的静态工厂方法,让客户端获取它自身的实例
     * 与构造器不同:
     *    优点:
     *      1.它们有名称.
     *      2.不必在每次调用它们的时候都创建一个新的对象.
     *      3.它们可以返回原返回类型的任何子类型对象.
     *      4.在创建参数化类型实例的时候,它们使代码变得更加简洁.
     *    缺点:
     *      1.类如果不含public和protected的constructor,就不能被子类化
     *      2.它们与其他的静态方法实际上没有任何区别
     */
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    public static void main(String[] args) {
        longTest();
    }

    /**
     * 要优先使用基本类型而不是装修基本类型,当心无意识的自动装箱
     */
    public static void longTest() {
        long startTime = DateTime.now().getMillis();
        //因为声明是Long,竟然导致生成了0x7fffffff个Long对象
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}

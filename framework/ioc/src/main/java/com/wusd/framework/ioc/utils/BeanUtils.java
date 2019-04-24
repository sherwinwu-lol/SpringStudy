package com.wusd.framework.ioc.utils;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * 负责处理对象的实例化
 */
public class BeanUtils {

    /**
     * 使用cglib获取实例
     * @param clz
     * @param ctr
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T instanceByCglib(Class<T> clz, Constructor ctr, Object[] args) {
        Enhancer enhancer = new Enhancer();
        //设置超类为这个类,实质就enhancer继承这个类,访问的是enhancer,通过这样实现动态代理
        enhancer.setSuperclass(clz);
        enhancer.setCallback(NoOp.INSTANCE);

        //如果构造器为空,直接创建实例
        if (ctr == null) {
            return (T) enhancer.create();
        }
        //如果构造器不为空,根据构造器类型,和对应的传参创建实例
        else {
            return (T) enhancer.create(ctr.getParameterTypes(), args);
        }
    }

}

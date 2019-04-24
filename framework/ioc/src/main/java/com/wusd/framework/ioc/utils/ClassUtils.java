package com.wusd.framework.ioc.utils;

//负责处理Java类的加载
public class ClassUtils {

    /**
     * 获取当前前线程的上下文加载器
     * @return
     */
    public static ClassLoader getDefaultClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 根据className反向获取这个类
     * @param className
     * @return
     */
    public static Class loadClass(String className) {
        try {
            return getDefaultClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}

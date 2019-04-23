package com.wusd.framework.ioc.util;

/**
 * 负责Java类的加载
 */
public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 通过className这个参数获取对象的Class
     * @param className
     * @return
     */
    public static Class loadClass(String className) {
        try {
            return getDefaultClassLoader().loadClass(className);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

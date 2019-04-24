package com.wusd.framework.ioc.utils;

import java.lang.reflect.Field;

/**
 * 利用Java反射原理来完成对象的依赖注入
 */
public class ReflectionUtils {

    /**
     * 设置obj的field为value
     * @param field
     * @param obj
     * @param value
     * @throws IllegalAccessException
     */
    public static void injectField(Field field, Object obj, Object value) throws IllegalAccessException {
        if (field != null) {
            field.setAccessible(true);
            field.set(obj, value);
        }
    }
}

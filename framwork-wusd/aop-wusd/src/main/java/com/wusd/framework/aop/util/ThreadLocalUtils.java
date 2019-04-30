package com.wusd.framework.aop.util;

public class ThreadLocalUtils {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static long get() {
        if (threadLocal == null) {
            throw new IllegalStateException("ThreadLocal");
        }
        return threadLocal.get();
    }

    public static void set(long startTime) {
        threadLocal.set(startTime);
    }

    public static void remove() {
        threadLocal.remove();
    }
}

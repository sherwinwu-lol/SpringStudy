package com.wusd.framework.ioc.core;

public interface BeanFactory {
    Object getBean(String name) throws Exception;
}

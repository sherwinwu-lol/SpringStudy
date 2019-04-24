package com.wusd.framework.ioc.core;

/**
 * 目前只支持一种ByName的注入
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

}

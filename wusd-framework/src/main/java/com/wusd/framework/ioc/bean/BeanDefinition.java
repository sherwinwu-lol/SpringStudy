package com.wusd.framework.ioc.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * IOC框架管理的对象
 */
@Data
@ToString
public class BeanDefinition {
    private String name;

    private String className;

    private String interfaceName;

    //构造函数的传参列表
    private List<ConstructorArg> constructorArgs;

    //需要注入的参数列表
    private List<PropertyArg> propertyArgs;
}

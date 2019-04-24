package com.wusd.framework.ioc.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 核心数据结构,用于描述我们需要IoC框架管理的对象
 */
@Data
@ToString
public class BeanDefinition {

    //名称
    private String name;

    //类名称
    private String className;

    //接口名称
    private String[] interfaceName;

    //构造器参数
    private List<ConstructorArg> constructorArgs;

    //字段参数
    private List<PropertyArg> propertyArgs;

}

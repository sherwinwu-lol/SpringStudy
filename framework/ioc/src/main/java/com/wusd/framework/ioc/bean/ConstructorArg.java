package com.wusd.framework.ioc.bean;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ConstructorArg {

    //索引,即构造器第几个参数
    private int index;
    //引用
    private String ref;
    //名称
    private String name;

}

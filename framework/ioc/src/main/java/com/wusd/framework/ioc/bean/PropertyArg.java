package com.wusd.framework.ioc.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PropertyArg {

    //名称
    private String name;

    //值
    private String value;

    //类型名称,即类全称
    private String typeName;

    //引用
    private String ref;
}

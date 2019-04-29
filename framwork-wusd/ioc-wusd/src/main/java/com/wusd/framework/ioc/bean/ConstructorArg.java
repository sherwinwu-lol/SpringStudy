package com.wusd.framework.ioc.bean;

import lombok.Data;

@Data
public class ConstructorArg {
    private int index;
    private String name;
    private String ref;
}

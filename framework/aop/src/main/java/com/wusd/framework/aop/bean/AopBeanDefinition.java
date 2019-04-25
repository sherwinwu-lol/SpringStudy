package com.wusd.framework.aop.bean;

import com.wusd.framework.ioc.bean.BeanDefinition;
import lombok.Data;

import java.util.List;

@Data
public class AopBeanDefinition extends BeanDefinition {
    private String target;

    private List<String> interceptorNames;
}

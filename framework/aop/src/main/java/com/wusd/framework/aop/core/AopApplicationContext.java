package com.wusd.framework.aop.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wusd.framework.aop.bean.AopBeanDefinition;
import com.wusd.framework.ioc.bean.BeanDefinition;
import com.wusd.framework.ioc.utils.ClassUtils;
import com.wusd.framework.ioc.utils.JsonUtils;

import java.io.InputStream;
import java.util.List;

public class AopApplicationContext extends AopBeanFactoryImpl {
    private String fileName;

    public AopApplicationContext(String fileName) {
        this.fileName = fileName;
    }

    public void init() {
        loadFile();
    }

    private void loadFile() {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

        List<AopBeanDefinition> beanDefinitions = JsonUtils.readValue(is, new TypeReference<List<AopBeanDefinition>>() {
        });

        if (beanDefinitions != null && !beanDefinitions.isEmpty()) {
            for (AopBeanDefinition beanDefinition : beanDefinitions) {
                Class<?> clazz = ClassUtils.loadClass(beanDefinition.getClassName());
                if (clazz == ProxyFactoryBean.class) {
                    registerBean(beanDefinition.getName(), beanDefinition);
                } else {
                    registerBean(beanDefinition.getName(), (BeanDefinition) beanDefinition);
                }
            }
        }
    }
}

package com.wusd.framework.ioc.core;

import com.wusd.framework.ioc.bean.BeanDefinition;
import com.wusd.framework.ioc.bean.ConstructorArg;
import com.wusd.framework.ioc.bean.PropertyArg;
import com.wusd.framework.ioc.util.BeanUtils;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactoryImpl implements BeanFactory {
    private static final ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private final Map<String, Object> earlySingletonObjects = new HashMap<>(16);
    @Override
    public Object getBean(String name) throws Exception {
        Object bean = beanMap.get(name);
        if (bean != null) {
            return bean;
        }

        Object earlyBean = earlySingletonObjects.get(name);
        if (earlyBean != null) {
            System.out.println("发生了循环依赖, 提前返回尚未加载完成的bean:" + name);
            return earlyBean;
        }
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        bean = createBean(beanDefinition);

        if (bean != null) {
            earlySingletonObjects.put(name, bean);
            populateBean(bean, beanDefinition);
            beanMap.put(name, bean);
            earlySingletonObjects.remove(name);
        }
        return bean;
    }

    protected void registerBean(String name, BeanDefinition bd) {
        beanDefinitionMap.put(name, bd);
    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception {
        String className = beanDefinition.getClassName();
        Class clazz = Class.forName(className);
        if (clazz == null) {
            throw new Exception("can not find bean by className");
        }
        List<ConstructorArg> constructorArgs = beanDefinition.getConstructorArgs();
        if (constructorArgs != null && !constructorArgs.isEmpty()) {
            List<Object> objects = new ArrayList<>();
            for (ConstructorArg arg : constructorArgs) {
                objects.add(getBean(arg.getRef()));
            }
            return BeanUtils.instanceByCglib(clazz, clazz.getConstructor(), objects.toArray());
        }
        else {
            return BeanUtils.instanceByCglib(clazz, null, null);
        }
    }

    private void populateBean(Object bean, BeanDefinition bd) throws Exception {
        List<PropertyArg> propertyArgs = bd.getPropertyArgs();
        for (PropertyArg arg : propertyArgs) {
            String propertyName = arg.getName();
            String value = arg.getValue();
            String ref = arg.getRef();
            Object injectValue = null;
            if (ref == null) {
                injectValue = value;
            }
            else if (ref != null && !"".equals(ref)) {
                injectValue = getBean(ref);
            }
            Method method = getPropertySetter(bd, propertyName, injectValue);
            method.invoke(bean, injectValue);
        }
    }

    private Method getPropertySetter(BeanDefinition bd, String propertyName, Object injectValue) throws Exception {
        Class beanClazz = Class.forName(bd.getClassName());
        Class injectClazz = injectValue.getClass();
        Class supClazz = injectClazz.getSuperclass();
        //父类不为Object,则注入父类
        if (supClazz != null && supClazz != Object.class) {
            injectClazz = supClazz;
        }
        propertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        Method method = beanClazz.getMethod("set" + propertyName, injectClazz);
        return method;
    }
}

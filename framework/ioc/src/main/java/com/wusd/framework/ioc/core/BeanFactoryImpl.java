package com.wusd.framework.ioc.core;

import com.wusd.framework.ioc.utils.ClassUtils;
import com.wusd.framework.ioc.bean.BeanDefinition;
import com.wusd.framework.ioc.bean.ConstructorArg;
import com.wusd.framework.ioc.bean.PropertyArg;
import com.wusd.framework.ioc.utils.BeanUtils;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactoryImpl implements BeanFactory {

    //用于存储实例化过的对象
    private static final ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String, BeanDefinition> beanDefineMap = new ConcurrentHashMap<>();

    private static final Set<String> beanNameSet = Collections.synchronizedSet(new HashSet<>());

    private final Map<String, Object> earlySingletonObjects = new HashMap<>(16);

    @Override
    public Object getBean(String name) throws Exception {
        //查找对象是否实例化过
        Object bean = beanMap.get(name);
        if (bean != null) {
            return bean;
        }
        //从单例map中寻找实例,避免循环依赖.stackOverFlow
        Object earlyBean = earlySingletonObjects.get(name);
        if (earlyBean != null) {
            System.out.println("发生了循环依赖，提前返回尚未加载完成的bean:" + name);
            return earlyBean;
        }
        //如果没有实例化, 那就需要调用createBean来创建对象
        BeanDefinition beanDefinition = beanDefineMap.get(name);
        bean = createBean(beanDefinition);

        if (bean != null) {
            //为了解决循环依赖, 先添加到早期单例中
            earlySingletonObjects.put(name, bean);

            //对象创建成功以后, 注入对象需要的参数
            populatebean(bean, beanDefinition);

            //再吧对象存入Map中方便下次使用。
            beanMap.put(name, bean);

            //从早期单例Map中移除
            earlySingletonObjects.remove(name);
        }

        //结束返回
        return bean;
    }

    protected void registerBean(String name, BeanDefinition bd) {
        beanDefineMap.put(name, bd);
        beanNameSet.add(name);
    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception {
        //获取类全称
        String className = beanDefinition.getClassName();
        //反向获取类
        Class clz = ClassUtils.loadClass(className);
        if (clz == null) {
            throw new Exception("can not find bean by beanName");
        }
        //获取类的构造器参数具体信息
        List<ConstructorArg> constructorArgs = beanDefinition.getConstructorArgs();
        if (constructorArgs != null && !constructorArgs.isEmpty()) {
            //存储构造器的具体信息
            List<Object> objects = new ArrayList<>();
            for (ConstructorArg constructorArg : constructorArgs) {
                //通过递归的方式实现依赖注入
                objects.add(getBean(constructorArg.getRef()));
            }
            return BeanUtils.instanceByCglib(clz, clz.getConstructor(), objects.toArray());
        } else {
            return BeanUtils.instanceByCglib(clz, null, null);
        }
    }

    private void populatebean(Object bean, BeanDefinition bd) throws Exception {
        //属性参数列表
        List<PropertyArg> propertyArgs = bd.getPropertyArgs();
        if (propertyArgs != null && !propertyArgs.isEmpty()) {
            //遍历在json中配置的属性
            for (PropertyArg arg : propertyArgs) {
                //字段名称
                String propertyName = arg.getName();
                //字段值
                String value = arg.getValue();
                //字段引用
                String ref = arg.getRef();
                Object injectValue = null;
                if (value != null) {
                    //直接赋值
                    injectValue = value;
                } else if (ref != null && !"".equals(ref)) {
                    //循环获取,实现依赖注入
                    injectValue = getBean(ref);
                }
                Method method = getPropertySetter(bd, propertyName, injectValue);
                //反射的方式注入
                method.invoke(bean, injectValue);
            }
        }
    }

    /**
     * 获取具体某个属性的setter方法
     * 此处的做法比较简单粗暴
     * 实际上Spring在读取配置文件时就已经将各属性,方法,getter/setter都读取好了
     * 在这就只需要调用BeanWrapper的方法来为属性赋值就可以了.
     * @param bd
     * @param propertyName
     * @param injectValue
     * @return
     * @throws Exception
     */
    private Method getPropertySetter(BeanDefinition bd, String propertyName, Object injectValue) throws Exception {
        Class beanClass = Class.forName(bd.getClassName());
        Class injectClazz = injectValue.getClass();
        Class supClass = injectValue.getClass().getSuperclass();
        if (supClass != null && supClass != Object.class) {
            injectClazz = supClass;
        }
        propertyName = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
        Method setter = beanClass.getMethod("set" + propertyName, injectClazz);
        return setter;
    }
}

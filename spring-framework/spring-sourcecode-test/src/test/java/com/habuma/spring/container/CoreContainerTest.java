package com.habuma.spring.container;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreContainerTest {
    @Test
    public void testApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Person p = context.getBean("john", Person.class);

        System.out.println(p.getName());
        System.out.println(p.getSpouse().getName());
    }

    @Test
    public void testPostBeanProcessor() {

    }

}

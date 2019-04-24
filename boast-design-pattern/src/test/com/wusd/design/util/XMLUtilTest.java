package com.wusd.design.util;


import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class XMLUtilTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String filePath = "boast-design-pattern/target/classes/builderConfig.xml";
        String className = XMLUtil.getRootTag(filePath, "className");
        System.out.println(className);
        Object bean = XMLUtil.getBean(filePath);
        System.out.println();
        Arrays.asList(1, 2).stream().collect(Collectors.toList());
    }

}

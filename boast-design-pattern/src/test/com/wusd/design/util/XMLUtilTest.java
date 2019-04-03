package com.wusd.design.util;


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
    }

}

package com.wusd.design.sixth.one;

import com.wusd.design.util.XMLUtil;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        //针对抽象目标接口编程
        ScoreOperation operation;
        //读取配置文件
        operation = (ScoreOperation) XMLUtil.getBean("boast-design-pattern/target/classes/adapterConfig.xml");
        //定义成绩数组
        int scores[] = {84, 76, 50, 69, 90, 88, 96};
        int result[];
        int score;

        System.out.println("成绩排序结果:");
        result = operation.sort(scores);

        //遍历输出成绩
        Arrays.stream(scores).forEach(o -> {
            System.out.println(o + ",");
        });

        searchResult(result, 90, operation);
        searchResult(result, 92, operation);
    }

    public static void searchResult(int[] array, int key, ScoreOperation operation) {
        System.out.println("查找成绩:" + key);
        int score = operation.search(array, key);
        if (score != -1) {
            System.out.println("找到成绩" + key);
        }
        else {
            System.out.println("没有找到成绩" + key);
        }
    }
}

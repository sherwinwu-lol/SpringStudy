package com.springinaction;

import com.springinaction.knights.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
    /**
     * 只有knights.xml文件知道哪个骑士执行哪种探险任务
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //加载Spring上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
        //获取knight bean
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}

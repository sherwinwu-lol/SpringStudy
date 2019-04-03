package com.wusd.design.fifth.two;

import com.wusd.design.fifth.one.Actor;
import com.wusd.design.util.XMLUtil;
import lombok.extern.slf4j.Slf4j;

//编写如下客户端测试代码
@Slf4j
public class Client {
    public static void main(String[] args) {
        String filePath = "boast-design-pattern/target/classes/builderConfig.xml";
        //针对抽象建造者编程
        ActorBuilder ab;
        //反射生成具体建造者
        ab = (ActorBuilder) XMLUtil.getBean(filePath);
        //通过指挥者创建完整的建造者对象
        Actor actor;
        //通过指挥者创建完整的建造者对象
        actor = ActorBuilder.construct(ab);

        String type = actor.getType();
        log.info("type:{}", type);
        log.info("sex:{}", actor.getSex());
        log.info("face:{}", actor.getFace());
        log.info("costume:{}", actor.getCostume());
        log.info("hairstyle:{}", actor.getHairstyle());
    }
}

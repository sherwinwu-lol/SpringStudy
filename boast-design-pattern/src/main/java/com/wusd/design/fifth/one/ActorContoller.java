package com.wusd.design.fifth.one;

/**
 * 指挥者类ActorController定义了construct()方法,拥有ActorBuilder类型的参数
 * 在方法内部实现了游戏角色对象的逐步构建
 */
public class ActorContoller {
    //逐步构建复杂产品对象
    public Actor construct(ActorBuilder ab) {
        Actor actor;
        ab.buildType();
        ab.buildSex();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();
        actor = ab.createActor();
        return actor;
    }
}

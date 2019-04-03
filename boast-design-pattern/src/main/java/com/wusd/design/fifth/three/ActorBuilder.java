package com.wusd.design.fifth.three;

import com.wusd.design.fifth.one.Actor;

public abstract class ActorBuilder {
    protected Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairstyle();

    /**
     * *钩子方法
     */
    public boolean isBareheaded() {
        return false;
    }
    public Actor createActor() {
        return actor;
    }
}

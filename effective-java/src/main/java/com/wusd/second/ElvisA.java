package com.wusd.second;

import java.io.Serializable;

public class ElvisA implements Serializable {
    private static final ElvisA INSTANCE = new ElvisA();
    private ElvisA() {

    }
    public static ElvisA getInstance() {
        return INSTANCE;
    }
    public void leaveTheBuilding() {

    }

    /**
     * 防止生成假冒的Elvis
     */
    private Object readResolve() {
        //Return the one true ElvisA and left the garbage collection
        //take care of the Elvis impersonator.
        return INSTANCE;
    }
}

package com.wusd.fourth;

public class Super {
    //Broken - constructor invokes an overidable method
    public Super() {
        overrideMe();
    }
    public void overrideMe() {

    }
}

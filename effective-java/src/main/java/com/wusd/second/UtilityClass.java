package com.wusd.second;

//Noninstantiable utility class
public class UtilityClass {
    //Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }
    //Remainder omitted;
}

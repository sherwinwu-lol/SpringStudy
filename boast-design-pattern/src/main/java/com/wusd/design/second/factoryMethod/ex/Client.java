package com.wusd.design.second.factoryMethod.ex;

import com.wusd.design.util.XMLUtil;

public class Client {
    public static void main(String[] args) {
        Photo photo = (Photo) XMLUtil.getBean();
        photo.show();
    }
}

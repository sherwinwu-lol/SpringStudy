package com.wusd.design.bridgePattern;

import com.wusd.design.bridgePattern.ref.Image;
import com.wusd.design.bridgePattern.ref.ImageImp;

public class Client {
    public static void main(String[] args) {
        Image image;
        ImageImp imp;
        image = (Image) XMLUtil.getBean("image");
        imp = (ImageImp) XMLUtil.getBean("os");
        image.setImp(imp);
        image.parseFile("小龙女");
    }
}
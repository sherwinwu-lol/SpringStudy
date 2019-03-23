package com.wusd.design.second.factoryMethod.ex;

public class GIFPhotoFactory implements PhotoFactory {
    public Photo getPhoto() {
        return new GIFPhoto();
    }
}

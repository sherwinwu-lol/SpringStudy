package com.wusd.design.second.factoryMethod.ex;

public class JPGPhotoFactory implements PhotoFactory {
    public Photo getPhoto() {
        return new JPGPhoto();
    }
}

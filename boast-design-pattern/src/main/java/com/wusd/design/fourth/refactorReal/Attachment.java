package com.wusd.design.fourth.refactorReal;

import java.io.Serializable;

/**
 * 附件类
 */
public class Attachment implements Serializable {
    //附件名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void download() {
        System.out.println("下载附件,文件名为" + name);
    }
}

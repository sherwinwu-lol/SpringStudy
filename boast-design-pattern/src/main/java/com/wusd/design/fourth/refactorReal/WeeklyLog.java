package com.wusd.design.fourth.refactorReal;

import java.io.*;

/**
 * 工作周报类
 */
public class WeeklyLog implements Serializable {
    private Attachment attachment;
    private String name;
    private String date;

    //使用序列化技术实现深克隆
    public WeeklyLog deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);

        //将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeeklyLog) ois.readObject();
    }

}

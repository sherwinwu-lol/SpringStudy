package com.wusd.design.fourth.old;

/**
 * @Cloneable Java克隆声明标识接口
 */
public class WeeklyLog implements Cloneable {
    private String name;
    private String date;
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //克隆方法clone(),此处使用Java语言提供的克隆机制
    @Override
    public WeeklyLog clone() {
        Object obj = null;
        try {
            obj = super.clone();
            return (WeeklyLog) obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("Not support clone");
            return null;
        }
    }
}

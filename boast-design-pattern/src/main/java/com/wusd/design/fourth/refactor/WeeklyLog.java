package com.wusd.design.fourth.refactor;

/**
 * 工作周报WeeklyLog
 */
public class WeeklyLog implements Cloneable {
    //为了简化设计和实现,假设一份工作周报只有一个附件对象
    private Attachment attachment;
    private String name;
    private String content;

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    /**
     * 使用clone()方法实现浅克隆
     */
    @Override
    public WeeklyLog clone() {
        Object obj = null;
        try {
            obj = super.clone();
            return (WeeklyLog) obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制!");
            return null;
        }
    }
}

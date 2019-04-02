package com.wusd.design.fourth;

public class ConcretePrototype implements Prototype {
    //成员属性
    private String attr;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    /**
     * 克隆方法
     * @return
     */
    @Override
    public Prototype clone() {
        //创建新对象
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAttr(attr);
        return prototype;
    }
}

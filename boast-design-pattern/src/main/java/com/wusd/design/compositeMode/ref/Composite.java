package com.wusd.design.compositeMode.ref;

import java.util.ArrayList;

public class Composite extends Component {
    private ArrayList<Component> list = new ArrayList<>();

    public void add(Component c) {
        list.add(c);
    }

    public void remove(Component c) {
        list.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return list.get(i);
    }

    public void operation() {
        //容器构件具体业务方法的实现
        //递归调用成员构件的业务方法
        for (Object obj : list) {
            ((Component) obj).operation();
        }
    }
}
/**
 * 在容器构件中实现了在抽象构件中声明的所有方法,既包括业务方法,也包括用于访问和管理成员子构件的方法,
 * 如add(),remove()和getChild()等方法.需要注意的事在实现具体业务方法时,由于容器构件充当的事容器角色,
 * 包含成员构件,因此它将调用其成员构件的业务方法.
 * 在组合模式结构中,由于容器构件中仍然可以包含容器构件,因此在容器构件进行处理时需要使用递归算法,
 * 即在容器构件的operation()方法中递归调用其成员的operation()方法.
 */

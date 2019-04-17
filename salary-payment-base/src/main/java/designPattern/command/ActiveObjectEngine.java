package designPattern.command;

import java.util.LinkedList;

/**
 * Active object模式是实现多线程控制的古老技术,提供一个简单的多任务核心.
 */
public class ActiveObjectEngine {
    LinkedList itsCommands = new LinkedList();

    /**
     * 增加新命令
     * @param c
     */
    public void addCommands(Command c) {
        itsCommands.add(c);
    }

    /**
     * 遍历链表,执行并去除每个命令
     */
    public void run() {
        while (!itsCommands.isEmpty()) {
            //链表中的Command对象克隆自己并把克隆对象放到链表的尾部,链表永不为空
            Command c = (Command) itsCommands.getFirst();
            itsCommands.removeFirst();
            try {
                c.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

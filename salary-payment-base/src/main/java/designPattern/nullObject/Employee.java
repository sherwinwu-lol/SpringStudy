package designPattern.nullObject;

import java.util.Date;

public interface Employee {
    boolean isTimeToPay(Date payDate);

    void pay();

    // 在Employee中创建一个唯一NullEmployee的变量, 就可以达到目的.
    Employee NULL = new Employee() {
        @Override
        public boolean isTimeToPay(Date payDate) {
            return false;
        }

        @Override
        public void pay() {

        }
    };
}
/**
 * NULL OBJECT可以确保函数总是返回有效的对象,即使在它们失败时也是如此.这些失败的对象"什么也不做".
 */

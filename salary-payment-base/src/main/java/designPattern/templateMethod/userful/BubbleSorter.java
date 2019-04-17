package designPattern.templateMethod.userful;

public abstract class BubbleSorter {
    private int operations = 0;
    protected int length = 0;

    protected int doSort() {
        operations = 0;
        if (length <= 1) {
            return operations;
        }
        for (int nextToLast = length - 2; nextToLast >= 0; nextToLast--) {
            for (int index = 0; index <= nextToLast; index++) {
                if (outOfOrder(index)) {
                    swap(index);
                }
                operations++;
            }
        }
        return operations;
    }

    protected abstract void swap(int index);
    protected abstract boolean outOfOrder(int index);
}
/**
 * 可以创建为不同类型的对象排序的简单派生类.
 * 例如,可以创建IntBubbleSorter子类去排序整数数组,创建DoubleBubbleSorter子类去排序双精度浮点型.
 */

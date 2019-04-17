package designPattern.strategy;

public class QuickBubbleSorter {
    private int operations = 0;
    private int length = 0;
    private SortHandle itsSortHandle = null;

    public QuickBubbleSorter(SortHandle handle) {
        itsSortHandle = handle;
    }

    public int sort(Object array) {
        itsSortHandle.setArray(array);
        length = itsSortHandle.length();
        operations = 0;
        if (length <= 1) {
            return operations;
        }

        boolean thisPassInOrder = false;
        for (int nextToLast = length - 2; nextToLast >= 0 && !thisPassInOrder; nextToLast--) {
            thisPassInOrder = true;
            for (int index = 0; index <= nextToLast; index++) {
                if (itsSortHandle.outOfOrder(index)) {
                    itsSortHandle.swap(index);
                    thisPassInOrder = false;
                }
                operations++;
            }
        }
        return operations;
    }
}
/**
 * strategy模式比template method模式多提供了一个额外的好处.
 * 尽管Template method模式允许一个通用算法操作多个可能的具体实现,但是由于strategy模式完全遵循dip原则,
 * 从而允许每个具体实现都可以被多个不同的通用算法操纵.
 */

package strategy;

public class BubbleSorter {
    private int operations = 0;
    private int length = 0;
    private SortHandle itsSortHanle = null;

    public BubbleSorter(SortHandle handle) {
        itsSortHanle = handle;
    }

    public int sort(Object array) {
        itsSortHanle.setArray(array);
        length = itsSortHanle.length();
        operations = 0;
        if (length <= 1) {
            return operations;
        }
        for (int nextToLast = length - 2; nextToLast >= 0; nextToLast--) {
            for (int index = 0; index <= nextToLast; index++) {
                if (itsSortHanle.outOfOrder(index)) {
                    itsSortHanle.swap(index);
                }
                operations++;
            }
        }
        return operations;
    }
}

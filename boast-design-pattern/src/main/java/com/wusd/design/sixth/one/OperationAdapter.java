package com.wusd.design.sixth.one;

//操作适配器:适配器
public class OperationAdapter implements ScoreOperation {
    //定义适配者QuickSort对象
    private QuickSort sortObj;
    //定义适配者BinarySearch对象
    private BinarySearch searchObj;

    public OperationAdapter() {
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }

    public int[] sort(int array[]) {
        //调用适配者类QuickSort的排序方法
        return sortObj.quickSort(array);
    }

    public int search(int[] array, int key) {
        //调用适配者类BinarySearch的二分查找
        return searchObj.binarySearch(array, key);
    }
}

package com.wusd.design.sixth.one;

//抽象成绩操作类:目标接口
public interface ScoreOperation {
    //成绩排序
    int[] sort(int array[]);

    //成绩查找
    int search(int array[], int key);
}

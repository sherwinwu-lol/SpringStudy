package com.wusd.fourth;

/**
 * 具体策略类,StringLengthComparator是无状态的,
 * 因此作为一个Singleton是非常合适的.
 */
public class StringLengthComparator {
    private StringLengthComparator() {}
    public static final StringLengthComparator INSTANCE = new StringLengthComparator();
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}

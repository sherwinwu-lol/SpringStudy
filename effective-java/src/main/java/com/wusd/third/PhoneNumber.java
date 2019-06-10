package com.wusd.third;

import org.joda.time.DateTime;

public final class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;
    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ": " + arg);
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNumber == lineNumber
                && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }
//    @Override
//    public int hashCode() {
//        int result = 17;
//        result = 31 * result + areaCode;
//        result = 31 * result + prefix;
//        result = 31 * result + lineNumber;
//        return result;
//    }
    private volatile int hashCode;
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 17;
            result = 31 * result + areaCode;
            result = 31 * result + prefix;
            result = 31 * result + lineNumber;
        }
        return result;
    }
    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public int compareTo(PhoneNumber pn) {
        //Compare area codes
//        if (areaCode < pn.areaCode)
//            return -1;
//        if (areaCode > pn.areaCode)
//            return 1;
//        if (prefix < pn.prefix)
//            return -1;
//        if (prefix > pn.prefix)
//            return 1;
//        if (lineNumber < pn.lineNumber)
//            return -1;
//        if (lineNumber > pn.lineNumber)
//            return 1;
        //ref
        //使用其他需要非常小心,有可能数值越界
        int areaCodeDiff = areaCode - pn.areaCode;
        if (areaCodeDiff != 0)
            return areaCodeDiff;
        int prefixDiff = prefix - pn.prefix;
        if (prefixDiff != 0)
            return prefixDiff;
        return lineNumber - pn.lineNumber;
    }
}

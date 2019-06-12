package com.wusd.seventh;

import java.math.BigInteger;

public class Main {
    /**
     * Returns a BigInteger whose value is (this mod m). This method
     * differs from the remainder method in that it always returns a
     * non-negative BigInteger
     * @param m the modulus, which must be positive
     * @return this mod m
     * @throws ArithmeticException if m is less that or equals to 0
     */
    public BigInteger mod(BigInteger m) {
        if (m.signum() <= 0)
            throw new ArithmeticException("Modulus <= 0: " + m);
        //Do the computation
        return null;
    }
    //Private helper function for a recursive sort
    private static void sort(long a[], int offset, int length) {
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
    }
    //Simple use of varargs
    static int sum(int... args) {
        int sum = 0;
        for (int arg : args)
            sum += arg;
        return sum;
    }
    //The WRONG way to use varargs to pass one or more arguments!
    static int min(int... args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Too few arguments");
        int min = args[0];
        for (int i = 1; i < args.length; i++)
            if (args[i] < min)
                min = args[i];
        return min;
    }
    //The right way to use varargs to pass one or more arguments
    static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }
}

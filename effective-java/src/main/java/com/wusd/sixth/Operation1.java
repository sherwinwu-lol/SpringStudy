package com.wusd.sixth;

import java.util.HashMap;
import java.util.Map;

//Enum type that switches on its own value - questionable
public enum Operation1 {
    PLUS("+") {
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        double apply(double x, double y) {
            return x / y;
        }
    };
    private final String symbol;
    Operation1(String symbol) {
        this.symbol = symbol;
    }
    @Override
    public String toString() {
        return symbol;
    }
    abstract double apply(double x, double y);
    //Implementing a fromString method on an enum type
    private static final Map<String, Operation1> stringToEnum = new HashMap<>();
    static {//Initialize map from constant name to enum constant
        for (Operation1 op : values())
            stringToEnum.put(op.toString(), op);
    }
    //Returns Operations for string, or null if string is invalid
    public static Operation1 fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (Operation1 op : Operation1.values())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
    //Do the arithmetic op represented by this constant
//    double apply(double x, double y) {
//        switch (this) {
//            case PLUS: return x + y;
//            case MINUS: return x - y;
//            case TIMES: return x * y;
//            case DIVIDE: return x / y;
//        }
//        throw new AssertionError("Unknown op: " + this);
//    }
}

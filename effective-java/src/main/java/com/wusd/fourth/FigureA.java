package com.wusd.fourth;

//Tagged class - vastly inferior to a class hierarchy!
public class FigureA {
    enum ShapeA { RECTANGLE, CIRCLE };

    //Tag field - the shape of this figure
    final ShapeA shape;

    //These field are used only if shape is RECTANGLE
    double length;
    double width;

    //This field is used only if shape is CIRCLE
    double radius;

    //Constructor for circle
    FigureA(double radius) {
        shape = ShapeA.CIRCLE;
        this.radius = radius;
    }

    //Constructor for rectangle
    FigureA(double length, double width) {
        shape = ShapeA.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError();
        }
    }
}

package typeinfo.shapes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    public abstract String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
        //实际上将所有的事物都当作Object持有--会自动将结果转型回Shape,在Java中,所有的类型转换都是在运行时进行正确性检查的
        shapeList.forEach(Shape::draw);
    }
}

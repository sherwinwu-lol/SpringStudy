package typeinfo.ex1;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HShape {
    boolean highlighted = false;
    public void highlight() {
        highlighted = true;
    }
    public void clearHighlight() {
        highlighted = false;
    }
    void draw() {
        System.out.println(this + " draw()");
    }

    @Override
    public String toString() {
        return getClass().getName() + (highlighted ? " highlighted" : " normal");
    }
    static List<HShape> shapes = new ArrayList<>();
    HShape() {
        shapes.add(this);
    }
    static void highlight(Class<?> type) {
        for (HShape shape : shapes) {
            if (type.isInstance(shape)) {
                shape.highlight();
            }
        }
    }
    static void clearHiglight(Class<?> type) {
        for (HShape shape : shapes) {
            if (type.isInstance(shape)) {
                shape.clearHighlight();
            }
        }
    }
    static void forEach(Class<?> type, String method) {
        try {
            Method m = HShape.class.getMethod(method, (Class<?>[]) null);
            for (HShape shape : shapes) {
                if (type.isInstance(shape)) {
                    m.invoke(shape, (Object[]) null);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static void hightlight2(Class<?> type) {
        forEach(type, "highlight");
    }
    static void clearHightlight2(Class<?> type) {
        forEach(type, "clearHighlight");
    }
}

class HCircle extends HShape {}
class HSquare extends HShape {}
class HTriangle extends HShape {}
public class E06_Highlight {
    public static void main(String[] args) {
        List<HShape> shapes = Arrays.asList(
                new HCircle(), new HSquare(),
                new HTriangle(), new HSquare(),
                new HTriangle(), new HCircle(),
                new HCircle(), new HSquare());
        HShape.highlight(HCircle.class);
        HShape.hightlight2(HCircle.class);
        for (HShape shape : shapes) {
            shape.draw();
        }
        System.out.println("******");
        HShape.highlight(HShape.class);
        HShape.hightlight2(HShape.class);
        for (HShape shape : shapes) {
            shape.draw();
        }
        System.out.println("******");
        HShape.clearHiglight(ArrayList.class);
        HShape.clearHightlight2(ArrayList.class);
        for (HShape shape : shapes) {
            shape.draw();
        }
    }
}

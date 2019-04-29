package typeinfo;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
interface NewInterface {}
class Toy {
    Toy() {}
    Toy(int i) {}
}
class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}
public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        //标准
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            //也可以正确检测接口
            c = Class.forName("typeinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            //我不知道你的确切类型,但是无论如何要正确地创建你自己
            //调用了默认构造器,如果默认构造器没有,则无法创建实例
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
        System.out.println("begin NewInterface");
        Class c1 = null;
        try {
            c1 = Class.forName("typeinfo.NewInterface");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find NewInterface");
        }
        printInfo(c1);
    }
}
/**
 Class name: typeinfo.FancyToy is interface? [false]
 Simple name: FancyToy
 Canonical name: typeinfo.FancyToy
 Class name: typeinfo.HasBatteries is interface? [true]
 Simple name: HasBatteries
 Canonical name: typeinfo.HasBatteries
 Class name: typeinfo.Waterproof is interface? [true]
 Simple name: Waterproof
 Canonical name: typeinfo.Waterproof
 Class name: typeinfo.Shoots is interface? [true]
 Simple name: Shoots
 Canonical name: typeinfo.Shoots
 Class name: typeinfo.Toy is interface? [false]
 Simple name: Toy
 Canonical name: typeinfo.Toy
 */

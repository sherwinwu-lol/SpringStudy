package typeinfo;

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}
class Gum {
    static {
        System.out.println("Loading Gum");
    }
}
class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

/**
 * 所有的类都是在对其第一次使用时,动态加载到JVM中.
 * Java程序在它开始运行之前并非被完全加载,其各个部分是在必需时才加载的.
 */
public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating Candy");
        try {
            Class.forName("typeinfo.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
/**
 inside main
 Loading Candy
 After creating Candy
 Loading Gum
 After Class.forName("Gum")
 Loading Cookie
 After creating Cookie
 */

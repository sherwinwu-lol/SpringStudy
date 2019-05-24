package typeinfo;

import java.lang.reflect.Field;

import static net.mindview.util.Print.print;

class WithPrivateFinalField {
    private int i = 1;
    private final String s = "I'm totally safe";
    private String s2 = "Am I safe?";
    public String toString() {
         return "i = " + i + ", " + s + ", " + s2;
    }
}
public class ModifyingPrivateFields {
    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        print(pf);
        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        print("f.getInt(pf): " + f.getInt(pf));
        f.setInt(pf, 47);
        print(pf);
        f = pf.getClass().getDeclaredField("s");
    }
}

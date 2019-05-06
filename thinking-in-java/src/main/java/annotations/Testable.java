package annotations;

import net.mindview.atunit.Test;

import static net.mindview.util.Print.print;

public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    /**
     * 注解和public, static void从语法的角度使用方式一样
     */
    @Test
    void testExecute() {
        execute();
    }
}

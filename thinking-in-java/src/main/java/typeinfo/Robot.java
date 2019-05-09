package typeinfo;

import net.mindview.util.Null;

import java.util.List;

import static net.mindview.util.Print.print;

public interface Robot {
    String name();
    String model();
    List<Operation> operations();
    class Test {
        public static void test(Robot r) {
            if (r instanceof Null)
                print("[Null Robot]");
            print("Robot name: " + r.name());
            print("Robot model: " + r.model());
            for (Operation operation : r.operations()) {
                print(operation.description());
                operation.command();
            }
        }
    }
}

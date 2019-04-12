import java.util.LinkedList;

public class ActiveObjectEngine {
    LinkedList itsCommands = new LinkedList();
    public void addCommands(Command c) {
        itsCommands.add(c);
    }

    public void run() {
        while (!itsCommands.isEmpty()) {
            Command c = (Command) itsCommands.getFirst();
            itsCommands.removeFirst();
            try {
                c.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

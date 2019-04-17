import designPattern.command.ActiveObjectEngine;
import designPattern.command.Command;
import designPattern.command.SleepCommand;
import junit.framework.*;
import junit.swingui.TestRunner;

public class TestSleepCommand extends TestCase {
    public static void main(String[] args) {
        TestRunner.main(new String[]{"TestSleepCommand"});
    }

    public TestSleepCommand(String name) {
        super(name);
    }

    private boolean commandExecuted = false;

    public void testSleep() throws Exception {
        Command wakeup = new Command() {
            @Override
            public void execute() throws Exception {
                commandExecuted = true;
            }
        };
        ActiveObjectEngine e = new ActiveObjectEngine();
        SleepCommand c = new SleepCommand(1000, e, wakeup);
        e.addCommands(c);
        long start = System.currentTimeMillis();
        e.run();
        long stop = System.currentTimeMillis();
        long sleepTime = stop - start;

        assertTrue("sleepTime " + sleepTime + " expected > 1000", sleepTime > 1000);
        assertTrue("sleepTime " + sleepTime + " expected > 1100", sleepTime < 1100);
        assertTrue("Command Executed", commandExecuted);

    }
}

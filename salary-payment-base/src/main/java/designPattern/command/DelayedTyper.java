package designPattern.command;

public class DelayedTyper implements Command {
    private long itsDelay;
    private char itsChar;
    private static ActiveObjectEngine engine = new ActiveObjectEngine();
    private static boolean stop = false;

    public static void main(String[] args) throws Exception {
        engine.addCommands(new DelayedTyper(100, '1'));
        engine.addCommands(new DelayedTyper(300, '3'));
        engine.addCommands(new DelayedTyper(500, '5'));
        engine.addCommands(new DelayedTyper(700, '7'));

        Command stopCommand = new Command() {
            @Override
            public void execute() throws Exception {
                stop = true;
            }
        };

        engine.addCommands(new SleepCommand(20000, engine, stopCommand));
        engine.run();
    }

    public DelayedTyper(long delay, char c) {
        itsDelay = delay;
        itsChar = c;
    }

    /**
     * 打印出在构造时传入的字符,检查stop标志.
     * 该标志没有被设置时调用delayAndRepeat.
     *
     * @throws Exception
     */
    @Override
    public void execute() throws Exception {
        System.out.print(itsChar);
        if (!stop) {
            delayAndRepeat();
        }
    }

    /**
     * 使用构造时传入的延迟构造了一个SleepCommand对象,
     * 再把构造后的SleepCommand对象插入ActiveObjectEngine中.
     *
     * @throws CloneNotSupportedException
     */
    private void delayAndRepeat() throws CloneNotSupportedException {
        engine.addCommands(new SleepCommand(itsDelay, engine, this));
    }
}
/**
 * 维持一个循环,循环重复打印一个指定字符等待一个指定的延迟.当stop标志被设置时,就退出循环.
 *
 * 字符串之所以有差别是因为CPU时钟和实时时钟没有完美的同步.
 *
 * COMMAND模式可以应用于数据库事务操作,设备控制,多线程核心以及GUI的do/undo管理.
 */
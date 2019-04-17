package designPattern.command;

public class SleepCommand implements Command {
    private Command wakeupCommand = null;
    private ActiveObjectEngine engine = null;
    private long sleepTime = 0;
    private long startTime = 0;
    private boolean started = false;

    public SleepCommand(long milliseconds, ActiveObjectEngine e, Command wakeupCommand) {
        //延迟毫秒数
        sleepTime = milliseconds;
        //引擎对象
        engine = e;
        //wakeup的另一个命令对象
        this.wakeupCommand = wakeupCommand;
    }
    /**
     * 检查自己以前是否已经执行,如果没有,就记录开始时间.如果没有过延迟时间,
     * 就把自己再加到ActiveObjectEngine中.如果过了延迟时间,就把wakeup命令对象加到ActiveObjectEngine中.
     */
    @Override
    public void execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if (!started) {
            started = true;
            startTime = currentTime;
            engine.addCommands(this);
        }
        else if ((currentTime - startTime) < sleepTime) {
            engine.addCommands(this);
        }
        else {
            engine.addCommands(wakeupCommand);
        }
    }
}
/**
 * 该程序和等待一个事件的多线程程序做一个类比.
 * 当多线程程序中的一个线程等待一个事件时, 通常调用一些操作系统调用阻塞自己直到事件发生.
 * SleepCommand并没有阻塞.相反,如果等待的((currentTime - startTime)<sleepTime)这个事件没有发生,
 * 它只是把自己放回到ActiveObjectEngine中.
 *
 * 采用该技术的变体去构建多线程系统是很常见的实践.run-to-completion任务,因为每个Command实例在下一个Command实例可以运行之前就运行完成了.
 * RTC的名字意味着Command实例不会阻塞.
 *
 * 它们共享运行时堆栈,不必为每个RTC线程定义或者分配各自的运行时堆栈.
 */

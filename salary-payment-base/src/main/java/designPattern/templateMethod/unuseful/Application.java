package designPattern.templateMethod.unuseful;

/**
 * run函数中,主循环,所有工作都交付给抽象方法init、idle以及cleanup
 * init处理任何所需初始化工作
 * idle处理程序的主要工作,并且在setDone方法被调用之前重复调用
 * cleanup处理程序退出前所需的所有清理工作
 */
public abstract class Application {
    private boolean isDone = false;
    protected abstract void init();
    protected abstract void idle();
    protected abstract void cleanup();

    protected void setDone() {
        isDone = true;
    }

    protected boolean done() {
        return isDone;
    }

    public void run() {
        init();
        while (!done()) {
            idle();
        }
        cleanup();
    }
}

package designPattern.monostate.usage;

public class Turnstile {
    private static boolean isLocked = false;
    private static boolean isAlarming = false;
    private static int itsCoins = 0;
    private static int itsRefunds = 0;
    protected final static Turnstile LOCKED = new Locked();
    protected final static Turnstile UNLOCKED = new UnLocked();
    protected static Turnstile itsState = LOCKED;

    public void reset() {

    }

    public boolean locked() {
        return isLocked;
    }

    public boolean alarm() {
        return isAlarming;
    }

    public void coin() {
        itsState.coin();
    }

    public void pass() {
        itsState.pass();
    }

    protected void lock(boolean shouldLock) {
        isLocked = shouldLock;
    }

    protected void alarm(boolean shouldAlarm) {
        isAlarming = shouldAlarm;
    }

    public int coins() {
        return itsCoins;
    }

    public void deposit() {
        itsCoins++;
    }

    public void refund() {
        itsRefunds++;
    }

    static class Locked extends Turnstile {
        public void coin() {
            itsState = UNLOCKED;
            lock(false);
            alarm(false);
            deposit();
        }
    }

    static class UnLocked extends Turnstile {
        public void coin() {
            refund();
        }

        public void pass() {
            lock(true);
            itsState = LOCKED;
        }
    }
}

/**
 * SINGLETON模式使用私有构造函数,一个静态变量,以及一个静态方法对实例化进行控制和限制.
 * MONOSTATE模式只是简单地把对象的所有变量变成静态的.
 *
 * 如果希望通过派生去约束一个现存类, 并且不介意它的所有调用者都必须要调用instance方法来获取访问权,那么SINGLETON是最合适的.
 * 如果希望类的单一性本质对使用者透明, 或者希望使用单一对象的多态派生对象, 那么MONOSTATE是最适合的.
 */

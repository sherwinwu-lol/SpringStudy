package monostate.usage;

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

    class Locked extends Turnstile {
        public void coin() {
            itsCoins = UNLOCKED;
            lock(false);
            alarm(false);
            deposit();
        }
    }

    class UnLocked extends Turnstile {
        public void coin() {
            refund();
        }

        public void pass() {
            lock(true);
            itsState = LOCKED;
        }
    }
}

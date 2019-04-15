package strategy;

public interface Application {
    void init();
    void idle();
    void cleanup();
    boolean done();
}

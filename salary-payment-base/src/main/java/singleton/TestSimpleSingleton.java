package singleton;

import junit.framework.TestCase;

import java.lang.reflect.Constructor;

public class TestSimpleSingleton extends TestCase {
    public TestSimpleSingleton(String name) {
        super(name);
    }

    public void testCreateSingleton() {
        Singleton s = Singleton.instance();
        Singleton s2 = Singleton.instance();
        assertSame(s, s2);
    }

    public void testNoPublicConstructors() throws Exception {
        Class singleton = Class.forName("singleton.Singleton");
        Constructor[] constructors = singleton.getConstructors();
        assertEquals("Singleton has public constructors.", 0, constructors.length);
    }
}

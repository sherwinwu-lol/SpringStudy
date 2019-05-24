package typeinfo;

import typeinfo.interfacea.A;

import static net.mindview.util.Print.print;

class AnoymousA {
    public static A makeA() {
        return new A() {
            public void f() {
                print("public C.f()");
            }
            public void g() {
                print("public C.g()");
            }
            void u() {
                print("package C.u()");
            }
            protected void v() {
                print("protected C.v()");
            }
            private void w() {
                print("private C.w()");
            }
        };
    }
}
public class AnnoymousImplementation {
    public static void main(String[] args) throws Exception {
        A a = AnoymousA.makeA();
        a.f();
        print(a.getClass().getName());
        // Reflection still gets into the anonymous class:
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");
    }
}

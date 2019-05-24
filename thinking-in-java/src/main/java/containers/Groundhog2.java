package containers;

public class Groundhog2 extends Groundhog {
    public Groundhog2(int n) {
        super(n);
    }
    public int hashCode() {
        return number;
    }
    public boolean equals(Object o) {
        //instanceof 检查了此对象是否为null
        return o instanceof Groundhog2 && (number == ((Groundhog2) o).number);
    }
}

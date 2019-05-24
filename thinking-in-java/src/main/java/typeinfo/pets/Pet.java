package typeinfo.pets;

public class Pet extends Individual implements Comparable {
    public Pet(String name) {
        super(name);
    }
    public Pet() {
        super();
    }
    public String toString() {
        return getClass().getSimpleName();
    }
    @Override
    public int compareTo(Object o) {
        if (o instanceof Individual) {
            return ((Individual) o).id.compareTo(this.id);
        }
        return 0;
    }
}

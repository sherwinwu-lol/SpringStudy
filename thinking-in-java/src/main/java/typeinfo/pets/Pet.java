package typeinfo.pets;

public class Pet extends Individual {
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
    public int compareTo(Individual o) {
        if (o instanceof Individual) {
            return  ((Long)o.id).compareTo(this.id);
        }
        return 0;
    }
}

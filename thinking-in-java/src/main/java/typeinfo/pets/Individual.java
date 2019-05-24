package typeinfo.pets;

public class Individual {
    public static Integer start = 47;
    public final Integer id = start++;
    public String name;
    public Individual(String name) {
        this.name = name;
    }

    public Individual() {}
    public Integer id() {
        return id;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

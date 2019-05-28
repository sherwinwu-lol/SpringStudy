package typeinfo.pets;

public class Individual implements Comparable<Individual> {
    private static long counter = 0;
    protected final long id = counter++;
    private String name;
    public Individual(String name) {
        this.name = name;
    }
    //'name' is optional:
    public Individual() {}
    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }
    public long id() {
        return id;
    }
    public boolean equals(Object o) {
        return o instanceof Individual && id == ((Individual)o).id;
    }
    public int hashCode() {
        int result = 17;
        if (name != null)
            result = 37 * result + name.hashCode();
        result = 37 * result + (int)id;
        return result;
    }

    /**
     * compareTo()方法有一个比较结构,因此它会产生一个排序序列,排序的规则首先按照实际类型排序,
     * 然后如果有名字的话,按照name排序,最后按照创建的顺序排序.
     */
    public int compareTo(Individual arg) {
        //Compare by class name first:
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if (firstCompare != 0)
            return firstCompare;
        if (name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);
            if (secondCompare != 0)
                return secondCompare;
        }
        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }
}

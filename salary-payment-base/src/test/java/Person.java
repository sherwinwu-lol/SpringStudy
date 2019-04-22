import lombok.Data;

@Data
public class Person extends People {
    private String fName;

    public Person() {
    }

    public Person(Integer id, String fName) {
        super(id);
        this.fName = fName;
    }
}

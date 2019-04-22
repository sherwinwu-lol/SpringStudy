import lombok.Data;

@Data
public class People {
    private Integer id;

    public People() {
    }

    public People(Integer id) {
        this.id = id;
    }
}

package impl.model;

import lombok.Data;

@Data
public class UnionAffiliation implements Affiliation {
    private int memberId;
    private double dues;

    public UnionAffiliation() {
    }

    public UnionAffiliation(int memberId, double dues) {
        this.memberId = memberId;
        this.dues = dues;
    }

    public void addServiceCharge(ServiceCharge sc) {

    }
}

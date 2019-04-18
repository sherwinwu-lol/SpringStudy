package impl.classification;

public class CommissionedClassification implements PaymentClassification {
    private double salary;
    private double comissionRate;

    public CommissionedClassification() {
    }

    public CommissionedClassification(double salary, double comissionRate) {
        this.salary = salary;
        this.comissionRate = comissionRate;
    }
}

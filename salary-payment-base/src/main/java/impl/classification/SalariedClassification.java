package impl.classification;

public class SalariedClassification implements PaymentClassification {
    private double salary;

    public SalariedClassification() {
    }

    public SalariedClassification(double salary) {
        this.salary = salary;
    }
}

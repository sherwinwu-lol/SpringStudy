package impl.model;

import impl.classification.PaymentClassification;
import impl.method.PaymentMethod;
import impl.schedule.PaymentSchedule;
import lombok.Data;

@Data
public class Employee {
    private int empId;
    private String name;
    private String address;

    private PaymentClassification classification;
    private PaymentSchedule schedule;
    private PaymentMethod method;

    public Employee() {
    }

    public Employee(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }
}

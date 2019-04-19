package impl.model;

import impl.classification.PaymentClassification;
import impl.method.PaymentMethod;
import impl.schedule.PaymentSchedule;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

@Data
public class Employee {
    private int empId;
    private String name;
    private String address;

    private Affiliation affiliation;

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

    public void payday(PayCheck pc) {
        double grossPay = classification.calculatePay(pc);
        double deductions = affiliation.calculateDeductions(pc);
        double netPay = grossPay - deductions;
        pc.setGrossPay(grossPay);
        pc.setDeductions(deductions);
        pc.setNetPay(netPay);
        method.pay(pc);
    }
}

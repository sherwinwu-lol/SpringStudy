package impl.transaction.add;

import impl.classification.CommissionedClassification;
import impl.classification.PaymentClassification;
import impl.schedule.BlweeklySchedule;
import impl.schedule.PaymentSchedule;
import impl.transaction.AddEmployeeTransaction;
import lombok.Data;

@Data
public class AddCommissionedEmployee extends AddEmployeeTransaction {
    private double salary;
    private double commissionRate;

    public AddCommissionedEmployee() {
    }

    public AddCommissionedEmployee(int empId, String name, String address, double salary, double commissionRate) {
        super(empId, name, address);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new BlweeklySchedule();
    }
}

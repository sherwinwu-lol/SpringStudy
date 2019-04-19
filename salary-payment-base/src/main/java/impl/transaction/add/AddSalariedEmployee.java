package impl.transaction.add;

import impl.classification.PaymentClassification;
import impl.classification.SalariedClassification;
import impl.schedule.MonthlySchedule;
import impl.schedule.PaymentSchedule;
import impl.transaction.AddEmployeeTransaction;

public class AddSalariedEmployee extends AddEmployeeTransaction {
    private double salary;

    public AddSalariedEmployee() {
    }

    public AddSalariedEmployee(int empId, String name, String address, double salary) {
        super(empId, name, address);
        this.salary = salary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }
}

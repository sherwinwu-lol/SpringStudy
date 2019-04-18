package impl.transaction.impl.sub;

import impl.classification.PaymentClassification;
import impl.classification.impl.SalariedClassification;
import impl.schedule.PaymentSchedule;
import impl.schedule.impl.MonthlySchedule;
import impl.transaction.impl.AddEmployeeTransaction;

public class AddSalariedEmployee extends AddEmployeeTransaction {
    float salary;

    public AddSalariedEmployee(int empid, String itsName, String itsAddress, float salary) {
        super(empid, itsAddress, itsName);
        this.salary = salary;
    }

    @Override
    public PaymentClassification getPaymentClassification() {
        return new SalariedClassification();
    }

    @Override
    public PaymentSchedule getPaymentSchedule() {
        return new MonthlySchedule();
    }
}

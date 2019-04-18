package impl.transaction.impl.sub;

import impl.classification.PaymentClassification;
import impl.schedule.PaymentSchedule;
import impl.schedule.impl.BlweeklySchedule;
import impl.classification.impl.CommissionedClassification;
import impl.transaction.impl.AddEmployeeTransaction;

public class AddCommissonedEmployee extends AddEmployeeTransaction {
    float salary;
    float commissionRate;

    public AddCommissonedEmployee(int empid, String itsAddress, String itsName, float salary, float commissionRate) {
        super(empid, itsAddress, itsName);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public PaymentClassification getPaymentClassification() {
        return new CommissionedClassification();
    }

    @Override
    public PaymentSchedule getPaymentSchedule() {
        return new BlweeklySchedule();
    }
}

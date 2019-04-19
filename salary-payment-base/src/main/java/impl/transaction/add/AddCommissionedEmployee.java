package impl.transaction.add;

import impl.classification.CommissionedClassification;
import impl.classification.PaymentClassification;
import impl.schedule.BlweeklySchedule;
import impl.schedule.PaymentSchedule;
import impl.transaction.AddEmployeeTransaction;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
    private double salary;
    private double commissionRate;

    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new BlweeklySchedule();
    }
}

package impl.transaction.change.classification;

import impl.classification.CommissionedClassification;
import impl.classification.PaymentClassification;
import impl.schedule.BlweeklySchedule;
import impl.schedule.PaymentSchedule;
import impl.transaction.change.ChangeClassificationTransaction;
import lombok.Data;

@Data
public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {
    private double salary;
    private double commissionRate;

    public ChangeCommissionedTransaction() {
    }

    public ChangeCommissionedTransaction(double salary, double commissionRate) {
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

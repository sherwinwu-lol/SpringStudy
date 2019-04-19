package impl.transaction.change.classification;

import impl.classification.PaymentClassification;
import impl.classification.SalariedClassification;
import impl.schedule.MonthlySchedule;
import impl.schedule.PaymentSchedule;
import impl.transaction.change.ChangeClassificationTransaction;
import lombok.Data;

@Data
public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
    private double salary;

    public ChangeSalariedTransaction() {
    }

    public ChangeSalariedTransaction(double salary) {
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

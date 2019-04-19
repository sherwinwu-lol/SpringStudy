package impl.transaction.change;

import impl.classification.PaymentClassification;
import impl.model.Employee;
import impl.schedule.PaymentSchedule;
import impl.transaction.ChangeEmployeeTransaction;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

    public abstract PaymentClassification getClassification();

    public abstract PaymentSchedule getSchedule();

    @Override
    public void change(Employee e) {
        PaymentClassification pc = getClassification();
        PaymentSchedule ps = getSchedule();

        e.setClassification(pc);
        e.setSchedule(ps);
    }
}

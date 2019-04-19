package impl.transaction.change.classification;

import impl.classification.HourlyClassification;
import impl.classification.PaymentClassification;
import impl.schedule.PaymentSchedule;
import impl.schedule.WeeklySchedule;
import impl.transaction.change.ChangeClassificationTransaction;
import lombok.Data;

@Data
public class ChangeHourlyTransaction extends ChangeClassificationTransaction {
    private double hourlyRate;

    public ChangeHourlyTransaction() {
    }

    public ChangeHourlyTransaction(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(hourlyRate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}

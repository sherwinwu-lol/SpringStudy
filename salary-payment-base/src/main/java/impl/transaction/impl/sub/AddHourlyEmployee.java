package impl.transaction.impl.sub;

import impl.classification.PaymentClassification;
import impl.classification.impl.HourlyClassification;
import impl.schedule.PaymentSchedule;
import impl.schedule.impl.BlweeklySchedule;
import impl.schedule.impl.WeeklySchedule;
import impl.transaction.impl.AddEmployeeTransaction;

public class AddHourlyEmployee extends AddEmployeeTransaction {
    float hourlyRate;

    public AddHourlyEmployee(int empid, String itsAddress, String itsName, float hourlyRate) {
        super(empid, itsAddress, itsName);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public PaymentClassification getPaymentClassification() {
        return new HourlyClassification();
    }

    @Override
    public PaymentSchedule getPaymentSchedule() {
        return new WeeklySchedule();
    }
}

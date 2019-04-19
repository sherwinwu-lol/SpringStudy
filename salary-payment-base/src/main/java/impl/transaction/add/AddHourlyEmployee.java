package impl.transaction.add;

import impl.classification.HourlyClassification;
import impl.classification.PaymentClassification;
import impl.schedule.PaymentSchedule;
import impl.schedule.WeeklySchedule;
import impl.transaction.AddEmployeeTransaction;

public class AddHourlyEmployee extends AddEmployeeTransaction {
    private double hourlyRate;

    public AddHourlyEmployee() {
    }

    public AddHourlyEmployee(int empId, String name, String address, double hourlyRate) {
        super(empId, name, address);
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

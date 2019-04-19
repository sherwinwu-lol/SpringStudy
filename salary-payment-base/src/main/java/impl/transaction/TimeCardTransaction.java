package impl.transaction;

import impl.classification.HourlyClassification;
import impl.classification.PaymentClassification;
import impl.database.PayrollDatabase;
import impl.model.Employee;
import impl.model.TimeCard;
import org.joda.time.DateTime;

public class TimeCardTransaction extends Transaction {
    private int empId;
    private DateTime dateTime;
    private double hours;
    @Override
    public void execute() throws Exception {
        Employee e = PayrollDatabase.getEmployee(empId);
        if (e != null) {
            try {
                PaymentClassification pc = e.getClassification();
                HourlyClassification hc = (HourlyClassification) pc;
                hc.addTimeCard(new TimeCard(dateTime, hours));
            } catch (Exception e1) {
                throw new Exception("Tried to add timecard to non-hourly employee");
            }
        } else {
            throw new Exception("No such employee.");
        }
    }
}

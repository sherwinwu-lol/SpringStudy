package impl.transaction;

import impl.classification.PaymentClassification;
import impl.database.PayrollDatabase;
import impl.model.Employee;
import org.joda.time.DateTime;

public class SalesReceiptTransaction implements Transaction {
    private DateTime dateTime;
    private double amount;
    private int empId;

    public SalesReceiptTransaction(DateTime dateTime, double amount, int empId) {
        this.dateTime = dateTime;
        this.amount = amount;
        this.empId = empId;
    }

    @Override
    public void execute() throws Exception {
        Employee e = PayrollDatabase.getEmployee(empId);
        PaymentClassification pc = e.getClassification();


    }
}

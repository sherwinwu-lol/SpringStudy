package impl.transaction;

import impl.classification.CommissionedClassification;
import impl.database.PayrollDatabase;
import impl.model.Employee;
import impl.model.SalesReceipt;
import org.joda.time.DateTime;

public class SalesReceiptTransaction extends Transaction {
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
        CommissionedClassification cc = (CommissionedClassification)e.getClassification();

        SalesReceipt sr = new SalesReceipt(amount, dateTime);

        cc.addSalesReceipt(sr);
    }
}

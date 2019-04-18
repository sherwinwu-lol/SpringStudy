package impl.transaction.impl;

import impl.classification.PaymentClassification;
import impl.database.PayrollDatabase;
import impl.method.PaymentMethod;
import impl.method.impl.HoldMethod;
import impl.model.Employee;
import impl.schedule.PaymentSchedule;
import impl.transaction.Transaction;

public class AddEmployeeTransaction implements Transaction {
    private int itsEmpId;
    private String itsAddress;
    private String itsName;

    PaymentSchedule paymentSchedule;
    PaymentClassification paymentClassification;

    public AddEmployeeTransaction(int itsEmpId, String itsName, String itsAddress) {
        this.itsEmpId = itsEmpId;
        this.itsAddress = itsAddress;
        this.itsName = itsName;
    }

    @Override
    public void execute() {
        PaymentClassification pc = getPaymentClassification();
        PaymentSchedule ps = getPaymentSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee e = new Employee(itsEmpId, itsName, itsAddress);
        e.setPaymentClassification(pc);
        e.setPaymentSchedule(ps);
        e.setPaymentMethod(pm);
        PayrollDatabase.addEmployee(itsEmpId, e);
    }

    public PaymentClassification getPaymentClassification() {
        return paymentClassification;
    }

    public PaymentSchedule getPaymentSchedule() {
        return paymentSchedule;
    }
}

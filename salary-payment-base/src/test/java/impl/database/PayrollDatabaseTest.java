package impl.database;

import impl.classification.PaymentClassification;
import impl.classification.impl.SalariedClassification;
import impl.model.Employee;
import impl.transaction.impl.sub.AddSalariedEmployee;

import static org.junit.Assert.*;

public class PayrollDatabaseTest {
    @org.junit.Test
    public void addEmployee() throws Exception {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "Bob", "Home", 1000.0f);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(1);
        assertEquals("Bob", e.getItsName());

        PaymentClassification pc = e.getPaymentClassification();
        SalariedClassification sc = (SalariedClassification) pc;

        assertEquals(1000.0f, sc);
    }

}
package impl.transaction.change.method;

import impl.method.HoldMethod;
import impl.method.PaymentMethod;
import impl.transaction.change.ChangeMethodTransaction;

public class ChangeHoldTransaction extends ChangeMethodTransaction {
    public ChangeHoldTransaction() {
    }

    public ChangeHoldTransaction(int empId) {
        super(empId);
    }

    @Override
    public PaymentMethod getMethod() {
        return new HoldMethod();
    }
}

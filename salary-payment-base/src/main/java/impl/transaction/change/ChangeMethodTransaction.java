package impl.transaction.change;

import impl.method.PaymentMethod;
import impl.model.Employee;
import impl.transaction.ChangeEmployeeTransaction;
import lombok.Setter;

@Setter
public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {
    public ChangeMethodTransaction() {
    }

    public ChangeMethodTransaction(int empId) {
        super(empId);
    }

    public abstract PaymentMethod getMethod();

    @Override
    public void change(Employee e) {
        e.setMethod(getMethod());
    }
}

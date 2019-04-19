package impl.transaction.change;

import impl.method.PaymentMethod;
import impl.model.Employee;
import impl.transaction.ChangeEmployeeTransaction;
import lombok.Setter;

@Setter
public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {
    private PaymentMethod method;

    public abstract PaymentMethod getMethod();

    @Override
    public void change(Employee e) {
        e.setMethod(getMethod());
    }
}

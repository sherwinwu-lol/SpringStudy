package impl.transaction.change.method;

import impl.method.MailMethod;
import impl.method.PaymentMethod;
import impl.model.Employee;
import impl.transaction.change.ChangeMethodTransaction;
import lombok.Data;

@Data
public class ChangeMailTransaction extends ChangeMethodTransaction {
    private String address;

    @Override
    public PaymentMethod getMethod() {
        return new MailMethod(address);
    }
}

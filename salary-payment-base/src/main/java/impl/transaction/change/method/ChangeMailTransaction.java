package impl.transaction.change.method;

import impl.method.MailMethod;
import impl.method.PaymentMethod;
import impl.transaction.change.ChangeMethodTransaction;
import lombok.Data;

@Data
public class ChangeMailTransaction extends ChangeMethodTransaction {
    private String address;

    public ChangeMailTransaction() {
    }

    public ChangeMailTransaction(int empId, String address) {
        super(empId);
        this.address = address;
    }

    @Override
    public PaymentMethod getMethod() {
        return new MailMethod(address);
    }
}

package impl.transaction.change.method;

import impl.method.DirectMethod;
import impl.method.PaymentMethod;
import impl.model.Employee;
import impl.transaction.change.ChangeMethodTransaction;
import lombok.Data;
import org.joda.time.DateTime;

@Data
public class ChangeDirectTransaction extends ChangeMethodTransaction {
    private String bank;
    private double account;

    @Override
    public PaymentMethod getMethod() {
        return new DirectMethod(bank, account);
    }
}

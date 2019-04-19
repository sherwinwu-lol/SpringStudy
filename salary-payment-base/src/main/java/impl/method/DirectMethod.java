package impl.method;

import impl.model.PayCheck;
import lombok.Data;
import org.joda.time.DateTime;

@Data
public class DirectMethod implements PaymentMethod {
    private String bank;
    private double account;

    public DirectMethod() {
    }

    public DirectMethod(String bank, double account) {
        this.bank = bank;
        this.account = account;
    }

    @Override
    public void pay(PayCheck pc) {

    }
}

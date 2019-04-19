package impl.method;

import impl.model.PayCheck;
import org.joda.time.DateTime;

public class MailMethod implements PaymentMethod {
    private String address;

    public MailMethod() {
    }

    public MailMethod(String address) {
        this.address = address;
    }

    @Override
    public void pay(PayCheck pc) {

    }
}

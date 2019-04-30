package impl.method;

import impl.model.PayCheck;

public interface PaymentMethod {
    void pay(PayCheck pc);
}

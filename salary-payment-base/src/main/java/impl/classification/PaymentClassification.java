package impl.classification;

import impl.model.PayCheck;
import org.joda.time.DateTime;

public interface PaymentClassification {
    double calculatePay(PayCheck pc);
}

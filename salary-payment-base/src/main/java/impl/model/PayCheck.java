package impl.model;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class PayCheck {
    private DateTime payDate;
    private double grossPay;
    private double netPay;
    private double deductions;

    public PayCheck() {
    }

    public PayCheck(DateTime payDate) {
        this.payDate = payDate;
    }
}

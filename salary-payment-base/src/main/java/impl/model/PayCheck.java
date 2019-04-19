package impl.model;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.Date;

@Data
public class PayCheck {
    private DateTime payStartDate;
    private DateTime payEndDate;
    private double grossPay;
    private double netPay;
    private double deductions;

    public PayCheck() {
    }

    public PayCheck(DateTime payStartDate, DateTime payEndDate) {
        this.payStartDate = payStartDate;
        this.payEndDate = payEndDate;
    }
}

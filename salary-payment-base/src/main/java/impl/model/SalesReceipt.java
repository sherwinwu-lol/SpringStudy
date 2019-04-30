package impl.model;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class SalesReceipt {
    private double amount;
    private DateTime dateTime;

    public SalesReceipt() {
    }

    public SalesReceipt(double amount, DateTime dateTime) {
        this.amount = amount;
        this.dateTime = dateTime;
    }
}

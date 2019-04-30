package impl.model;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class ServiceCharge {
    private DateTime dateTime;
    private double charge;

    public ServiceCharge() {
    }

    public ServiceCharge(DateTime dateTime, double charge) {
        this.dateTime = dateTime;
        this.charge = charge;
    }
}

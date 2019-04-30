package impl.model;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class TimeCard {
    private DateTime dateTime;
    private double hours;

    public TimeCard() {
    }

    public TimeCard(DateTime dateTime, double hours) {
        this.dateTime = dateTime;
        this.hours = hours;
    }
}

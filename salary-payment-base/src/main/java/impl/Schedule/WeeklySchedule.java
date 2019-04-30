package impl.schedule;

import org.joda.time.DateTime;

public class WeeklySchedule implements PaymentSchedule {
    @Override
    public boolean isPayDate(DateTime payDate) {
        return payDate.getDayOfWeek() == 5;
    }

    @Override
    public DateTime getPayStartDate(DateTime payEndDate) {
        return payEndDate.plusWeeks(-1);
    }
}

package impl.schedule;

import org.joda.time.DateTime;

public class BlweeklySchedule implements PaymentSchedule {

    @Override
    public boolean isPayDate(DateTime payDate) {
        return payDate.getDayOfWeek() == 5 && payDate.getWeekOfWeekyear() % 2 == 1;
    }

    @Override
    public DateTime getPayStartDate(DateTime payEndDate) {
        return payEndDate.plusWeeks(-2);
    }
}

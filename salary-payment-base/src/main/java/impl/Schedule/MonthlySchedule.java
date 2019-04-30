package impl.schedule;

import org.joda.time.DateTime;

public class MonthlySchedule implements PaymentSchedule {
    @Override
    public boolean isPayDate(DateTime payDate) {
        return payDate.equals(payDate.dayOfMonth().withMaximumValue());
    }

    @Override
    public DateTime getPayStartDate(DateTime payEndDate) {
        return payEndDate.plusMonths(1);
    }
}

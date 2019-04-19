package impl.schedule;

import org.joda.time.DateTime;

public interface PaymentSchedule {
    boolean isPayDate(DateTime payDate);

    DateTime getPayStartDate(DateTime payEndDate);
}

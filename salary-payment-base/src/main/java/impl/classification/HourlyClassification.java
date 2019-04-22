package impl.classification;

import impl.model.PayCheck;
import impl.model.TimeCard;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class HourlyClassification implements PaymentClassification {
    private double hourlyRate;
    private Map<DateTime, TimeCard> dateTimeTimeCardMap = new HashMap<>();

    public HourlyClassification() {
    }

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void addTimeCard(TimeCard timeCard) {
        dateTimeTimeCardMap.put(DateTime.now(), timeCard);
    }

    private boolean isInPayDate(TimeCard tc, DateTime payDate) {
        DateTime payEndDate = payDate;
        DateTime payStartDate = payDate.plusDays(-5);
        DateTime timeCardDate = tc.getDateTime();
        return (timeCardDate.compareTo(payStartDate) >= 0) && (timeCardDate.compareTo(payEndDate) <= 0);
    }

    private double calculatePayForTimeCard(TimeCard tc) {
        double hours = tc.getHours();
        double overtime = Math.max(0.0, hours - 8.0);
        double straightTime = hours - overtime;
        return straightTime * hourlyRate + overtime * hourlyRate * 1.5;
    }

    @Override
    public double calculatePay(PayCheck pc) {
        double totalPay = 0;
        DateTime payEndDate = pc.getPayEndDate();
        Set<DateTime> keySet = dateTimeTimeCardMap.keySet();
        List<TimeCard> timeCardList = keySet.stream().map(o -> {
            return dateTimeTimeCardMap.get(o);
        }).collect(Collectors.toList());

        totalPay = timeCardList.stream()
                .filter(o -> {
                    return isInPayDate(o, payEndDate);
                }).mapToDouble(o -> {
                    return calculatePayForTimeCard(o);
                }).reduce(0d, (sum, item) -> sum + item);
        return totalPay;
    }
}

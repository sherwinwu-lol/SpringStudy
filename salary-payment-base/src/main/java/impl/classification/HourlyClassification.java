package impl.classification;

import impl.model.TimeCard;

public class HourlyClassification implements PaymentClassification {
    private double hourlyRate;

    public HourlyClassification() {
    }

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void addTimeCard(TimeCard timeCard) {

    }
}

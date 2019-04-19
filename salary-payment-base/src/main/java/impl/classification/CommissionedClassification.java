package impl.classification;

import impl.model.PayCheck;
import impl.model.SalesReceipt;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommissionedClassification implements PaymentClassification {
    private double salary;
    private double comissionRate;
    private List<SalesReceipt> salesReceiptList = new ArrayList<>();

    public CommissionedClassification() {
    }

    public CommissionedClassification(double salary, double comissionRate) {
        this.salary = salary;
        this.comissionRate = comissionRate;
    }

    public void addSalesReceipt(SalesReceipt sr) {
        salesReceiptList.add(sr);
    }

    private boolean isInPayDate(SalesReceipt sr, DateTime payDate) {
        DateTime payEndDate = payDate;
        DateTime payStartDate = payDate.plusDays(-12);
        DateTime salasReceiptDate = sr.getDateTime();
        return salasReceiptDate.compareTo(payStartDate) >= 0 && salasReceiptDate.compareTo(payEndDate) <= 0;
    }

    @Override
    public double calculatePay(PayCheck pc) {
        DateTime payDate = pc.getPayDate();
        double totalPay = salesReceiptList.stream()
                .filter(o -> {
                    return isInPayDate(o, payDate);
                }).mapToDouble(SalesReceipt::getAmount)
                .reduce(0d, (sum, item) -> sum + item);
        return totalPay;
    }
}

package impl.model;

import impl.classification.PaymentClassification;
import impl.method.PaymentMethod;
import impl.schedule.PaymentSchedule;
import lombok.Data;

@Data
public class Employee {
    private int itsEmpId;
    private String itsName;
    private String itsAddress;

    private PaymentSchedule paymentSchedule;
    private PaymentClassification paymentClassification;
    private PaymentMethod paymentMethod;

    public Employee(int itsEmpId, String itsName, String itsAddress) {
        this.itsEmpId = itsEmpId;
        this.itsName = itsName;
        this.itsAddress = itsAddress;
    }

    public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public void setPaymentClassification(PaymentClassification paymentClassification) {
        this.paymentClassification = paymentClassification;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

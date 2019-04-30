package impl.transaction;

import impl.database.PayrollDatabase;
import impl.model.Affiliation;
import impl.model.Employee;
import impl.model.ServiceCharge;
import impl.model.UnionAffiliation;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.List;

@Data
public class ServiceChargeTransaction extends Transaction {
    private DateTime dateTime;
    private double charge;
    private int memberId;

    public ServiceChargeTransaction() {
    }

    public ServiceChargeTransaction(DateTime dateTime, double charge, int memberId) {
        this.dateTime = dateTime;
        this.charge = charge;
        this.memberId = memberId;
    }

    @Override
    public void execute() throws Exception {
        Employee e = PayrollDatabase.getEmployee(memberId);
        UnionAffiliation ua = (UnionAffiliation) e.getAffiliation();
        ServiceCharge sc = new ServiceCharge(dateTime, charge);
        ua.addServiceCharge(sc);
    }
}

package impl.transaction.change;

import impl.model.Affiliation;
import impl.model.Employee;
import impl.transaction.ChangeEmployeeTransaction;
import lombok.Setter;

@Setter
public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {
    private Affiliation affiliation;
    public ChangeAffiliationTransaction() {
    }

    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }

    public abstract void recodeMembership(Employee e);

    public abstract Affiliation getAffiliation();
    @Override
    public void change(Employee e) {
        recodeMembership(e);
        e.setAffiliation(e.getAffiliation());
    }
}

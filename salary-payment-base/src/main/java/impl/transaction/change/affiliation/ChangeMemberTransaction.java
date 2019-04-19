package impl.transaction.change.affiliation;

import impl.database.PayrollDatabase;
import impl.model.Affiliation;
import impl.model.Employee;
import impl.model.UnionAffiliation;
import impl.transaction.change.ChangeAffiliationTransaction;
import lombok.Data;

@Data
public class ChangeMemberTransaction extends ChangeAffiliationTransaction {
    private int memberId;
    private double dues;

    public ChangeMemberTransaction() {
    }

    public ChangeMemberTransaction(int empId, int memberId, double dues) {
        super(empId);
        this.memberId = memberId;
        this.dues = dues;
    }

    @Override
    public void recodeMembership(Employee e) {
        PayrollDatabase.addUnionMember(memberId, e);
    }

    @Override
    public Affiliation getAffiliation() {
        return new UnionAffiliation(memberId, dues);
    }
}

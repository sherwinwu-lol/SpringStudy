package impl.transaction.change.affiliation;

import impl.database.PayrollDatabase;
import impl.model.Affiliation;
import impl.model.Employee;
import impl.model.NoAffiliation;
import impl.model.UnionAffiliation;
import impl.transaction.change.ChangeAffiliationTransaction;
import lombok.Data;

@Data
public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {
    public ChangeUnaffiliatedTransaction() {
    }

    public ChangeUnaffiliatedTransaction(int empId) {
        super(empId);
    }

    @Override
    public void recodeMembership(Employee e) {
        UnionAffiliation uf = (UnionAffiliation) e.getAffiliation();
        int memberId = uf.getMemberId();
        PayrollDatabase.removeUnionMember(memberId);
    }

    @Override
    public Affiliation getAffiliation() {
        return new NoAffiliation();
    }
}

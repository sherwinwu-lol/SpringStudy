package impl.transaction;

import impl.database.PayrollDatabase;
import impl.model.Employee;
import lombok.Data;

@Data
public abstract class ChangeEmployeeTransaction extends Transaction {
    private int empId;

    public ChangeEmployeeTransaction() {
    }

    public ChangeEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    public abstract void change(Employee e);

    @Override
    public void execute() throws Exception {
        Employee e = PayrollDatabase.getEmployee(empId);
        if (e != null) {
            change(e);
        }
    }
}

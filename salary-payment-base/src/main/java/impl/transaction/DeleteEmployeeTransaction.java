package impl.transaction;

import impl.database.PayrollDatabase;

public class DeleteEmployeeTransaction extends Transaction {
    private int empId;

    public DeleteEmployeeTransaction() {
    }

    public DeleteEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        PayrollDatabase.delEmployee(empId);
    }
}

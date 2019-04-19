package impl.transaction.change.properties;

import impl.model.Employee;
import impl.transaction.ChangeEmployeeTransaction;
import lombok.Data;

@Data
public class ChangeNameTransaction extends ChangeEmployeeTransaction {
    private String name;

    public ChangeNameTransaction() {
    }

    public ChangeNameTransaction(int empId, String name) {
        super(empId);
        this.name = name;
    }

    @Override
    public void change(Employee e) {
        e.setName(name);
    }
}

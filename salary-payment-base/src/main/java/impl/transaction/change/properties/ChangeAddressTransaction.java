package impl.transaction.change.properties;

import impl.model.Employee;
import impl.transaction.ChangeEmployeeTransaction;
import lombok.Data;

@Data
public class ChangeAddressTransaction extends ChangeEmployeeTransaction {
    private String address;

    public ChangeAddressTransaction() {
    }

    public ChangeAddressTransaction(int empId, String address) {
        super(empId);
        this.address = address;
    }

    @Override
    public void change(Employee e) {
        e.setAddress(address);
    }
}

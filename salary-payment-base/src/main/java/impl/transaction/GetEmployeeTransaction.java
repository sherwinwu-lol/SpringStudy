package impl.transaction;

import com.alibaba.fastjson.JSON;
import impl.database.PayrollDatabase;
import impl.model.Employee;
import lombok.Data;

@Data
public class GetEmployeeTransaction extends Transaction {
    private int empId;

    public GetEmployeeTransaction() {
    }

    public GetEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() throws Exception {
        Employee employee = PayrollDatabase.getEmployee(empId);
        System.out.println(JSON.toJSONString(employee));
    }
}

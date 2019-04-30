package impl.transaction;

import impl.database.PayrollDatabase;
import impl.model.Employee;
import impl.model.PayCheck;
import org.joda.time.DateTime;

import java.util.List;

public class PaydayTransaction extends Transaction {
    @Override
    public void execute() throws Exception {
        DateTime now = DateTime.now();
        List<Employee> employeeList = PayrollDatabase.getEmployeeList();
        employeeList.stream()
                .forEach(o -> {
                    boolean isPayDay = o.isPayDate(now);
                    DateTime payStartDate = o.getPayStartDate(now);
                    if (isPayDay) {
                        PayCheck pc = new PayCheck(payStartDate, now);
                        o.payday(pc);
                    }
                    else {
                        System.out.println(o.getName() + " is not pay now!");
                    }
                });
    }
}

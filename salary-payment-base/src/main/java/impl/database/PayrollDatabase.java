package impl.database;

import impl.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {

    public static Map<Integer, Employee> itsEmployees = new HashMap<>();

    public static Employee getEmployee(int empId) {
        return itsEmployees.get(empId);
    }

    public static void addEmployee(int empId, Employee employee) {
        itsEmployees.put(empId, employee);
    }

    public static void clear() {
        itsEmployees.clear();
    }
}

package impl.database;

import impl.model.Employee;

import java.util.Map;

public class PayrollDatabase {
    private static Map<Integer, Employee> employeeMap;

    public static Employee getEmployee(int empId) {
        return employeeMap.get(empId);
    }

    public static void addEmployee(int empId, Employee e) {
        employeeMap.put(empId, e);
    }

    public static void delEmployee(int empId) {
        employeeMap.remove(empId);
    }
}

package impl.database;

import impl.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PayrollDatabase {
    private static Map<Integer, Employee> employeeMap;
    private static Map<Integer, Employee> memberEmployeMap;

    public static Employee getEmployee(int empId) {
        return employeeMap.get(empId);
    }

    public static void addEmployee(int empId, Employee e) {
        employeeMap.put(empId, e);
    }

    public static void delEmployee(int empId) {
        employeeMap.remove(empId);
    }

    public static Employee getUnionEmployee(int memberId) {
        return memberEmployeMap.get(memberId);
    }

    public static void addUnionMember(int memberId, Employee e) {
        memberEmployeMap.put(memberId, e);
    }

    public static void removeUnionMember(int memberId) {
        memberEmployeMap.remove(memberId);
    }

    public static List<Employee> getEmployeeList() {
        Set<Integer> empIdSet = employeeMap.keySet();
        List<Employee> employeeList = empIdSet.stream().map(o -> {
            return employeeMap.get(o);
        }).collect(Collectors.toList());
        return employeeList;
    }
}

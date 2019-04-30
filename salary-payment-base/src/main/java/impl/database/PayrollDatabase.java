package impl.database;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import impl.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PayrollDatabase {
    private static Map<Integer, Employee> employeeMap = new HashMap<>();
    private static Map<Integer, Employee> memberEmployeMap = new HashMap<>();

    public static Employee getEmployee(int empId) {
        Employee e =  employeeMap.get(empId);
        System.out.println("PayrollDatabase.getEmployee...e:" + JSONObject.toJSONString(e));
        return e;
    }

    public static void addEmployee(int empId, Employee e) {
        employeeMap.put(empId, e);
        System.out.println("PayrollDatabase.addEmployee...e:" + JSONObject.toJSONString(e));
    }

    public static void delEmployee(int empId) {
        employeeMap.remove(empId);
        System.out.println("PayrollDatabase.delEmployee...empId:" + empId);
    }

    public static Employee getUnionEmployee(int memberId) {
        Employee e =  memberEmployeMap.get(memberId);
        System.out.println("PayrollDatabase.getUnionEmployee...e:" + JSON.toJSONString(e));
        return e;
    }

    public static void addUnionMember(int memberId, Employee e) {
        memberEmployeMap.put(memberId, e);
        System.out.println("PayrollDatabase.getUnionEmployee...e:" + JSON.toJSONString(e));
    }

    public static void removeUnionMember(int memberId) {
        memberEmployeMap.remove(memberId);
        System.out.println("PayrollDatabase.removeUnionEmployee...memberId:" + memberId);
    }

    public static List<Employee> getEmployeeList() {
        Set<Integer> empIdSet = employeeMap.keySet();
        List<Employee> employeeList = empIdSet.stream().map(o -> {
            return employeeMap.get(o);
        }).collect(Collectors.toList());
        System.out.println("PayrollDatabase.getEmployeeList...employeeList:" + JSONObject.toJSONString(employeeList));
        return employeeList;
    }
}

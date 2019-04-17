package designPattern.nullObject;

public class DB {
    public static Employee getEmployee(String name) {
        return Employee.NULL;
    }
}

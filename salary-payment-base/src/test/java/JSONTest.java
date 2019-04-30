import com.alibaba.fastjson.JSON;
import impl.transaction.DeleteEmployeeTransaction;
import impl.transaction.Transaction;
import impl.transaction.add.AddSalariedEmployee;
import junit.framework.TestCase;

public class JSONTest extends TestCase {
    public void test() throws Exception{
        Transaction t = new AddSalariedEmployee(1, "张三", "张三的地址", 5000d);
        t = new DeleteEmployeeTransaction(1);
        create(t);
    }
    public void create(Transaction t) {
        String jsonString = JSON.toJSONString(t);
        Class<? extends Transaction> aClass = t.getClass();
        String canonicalName = aClass.getCanonicalName();
        jsonString = jsonString.substring(0, jsonString.length() - 1);

        String suffix = "\"className\":\"%s\"";
        suffix = String.format(suffix, canonicalName);
        jsonString = jsonString + "," + suffix + "}";
        System.out.println(jsonString);
    }
}
//import com.alibaba.fastjson.JSON;
//import impl.transaction.DeleteEmployeeTransaction;
//import impl.transaction.Transaction;
//import impl.transaction.add.AddCommissionedEmployee;
//import impl.transaction.add.AddHourlyEmployee;
//import impl.transaction.add.AddSalariedEmployee;
//import junit.framework.TestCase;
//
//public class JSONTest extends TestCase {
//    public void test() throws Exception{
//        Transaction t = new AddSalariedEmployee(1, "张三", "北京", 9000d);
//        create(t);
//        t = new AddCommissionedEmployee(2, "李四", "上海", 2000, 0.5d);
//        create(t);
//        t = new AddHourlyEmployee(3, "王五", "深圳", 20);
//        create(t);
//    }
//    public void create(Transaction t) {
//        String jsonString = JSON.toJSONString(t);
//        Class<? extends Transaction> aClass = t.getClass();
//        String canonicalName = aClass.getCanonicalName();
//        jsonString = jsonString.substring(0, jsonString.length() - 1);
//
//        String suffix = "\"className\":\"%s\"";
//        suffix = String.format(suffix, canonicalName);
//        jsonString = jsonString + "," + suffix + "}";
//        System.out.println(jsonString);
//    }
//}

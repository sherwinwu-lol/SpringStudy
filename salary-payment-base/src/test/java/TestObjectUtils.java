import impl.util.ObjectUtils;
import junit.framework.TestCase;

public class TestObjectUtils extends TestCase {
    public void test() throws Exception {
        Person person = new Person();
        person.setId(1);
        person.setFName("张三");
        Object val = ObjectUtils.getFieldValue(person, "id");
        System.out.println("1:" + val);
        val = ObjectUtils.setFieldValue(person, "id", 2);
        System.out.println("2:" + val);
        ObjectUtils.setFieldValue(person, "fName", "张");
        val = ObjectUtils.getFieldValue(person, "fName");
        System.out.println("3:" + val);
    }

    public void test2() throws Exception {
        Person person = new Person();
        person.setId(1);
        person.setFName("张三");
        Object val = ObjectUtils.getFieldValueD(person, "id");
        System.out.println("1:" + val);
        val = ObjectUtils.setFieldValueD(person, "id", 2);
        System.out.println("2:" + val);
        ObjectUtils.setFieldValueD(person, "fName", "张");
        val = ObjectUtils.getFieldValueD(person, "fName");
        System.out.println("3:" + val);

    }
}

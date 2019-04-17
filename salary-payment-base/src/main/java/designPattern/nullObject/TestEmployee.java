package designPattern.nullObject;

import junit.framework.TestCase;

import java.util.Date;

public class TestEmployee extends TestCase {
    /**
     * Bob不存于数据库中.所以isTimeToPay返回false
     * @throws Exception
     */
    public void testNull() throws Exception {
        Employee e = DB.getEmployee("Bob");
        if (e.isTimeToPay(new Date())) {
            fail();
        }
        assertEquals(Employee.NULL, e);
    }
}

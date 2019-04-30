package impl.util;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang.StringUtils;

import javax.print.DocFlavor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectUtils {
    public static final String PREFIX = "target/classes/";
    public static final String SUFFIX = ".xml";

    /**
     * 首字母大写
     * @param letter
     * @return
     */
    public static String upperFirstLetter(String letter) {
        if (StringUtils.isBlank(letter)) {
            return letter;
        }
        String firstLetter = letter.substring(0, 1).toUpperCase();
        return firstLetter + letter.substring(1);
    }

    /**
     * 反射获得属性值(通过get方法)
     * @param obj
     * @param fieldName
     * @return
     * @throws Exception
     */
    public static Object getFieldValue(Object obj, String fieldName) throws Exception {
        if (obj == null || StringUtils.isBlank(fieldName)) {
            return obj;
        }
        Class objClass = obj.getClass();
        String getMethodName = "get" + upperFirstLetter(fieldName);
        Method method = objClass.getMethod(getMethodName);
        if (method != null) {
            obj = method.invoke(obj);
        }
        return obj;
    }

    /**
     * 反射设置属性值(通过set方法)
     * @param obj
     * @param fieldName
     * @param fieldValue
     * @return
     * @throws Exception
     */
    public static Object setFieldValue(Object obj, String fieldName, Object fieldValue) throws Exception {
        if (obj == null || StringUtils.isBlank(fieldName)) {
            return obj;
        }
        Class beanClass = obj.getClass();
        String setMethodName = "set" + upperFirstLetter(fieldName);
        Method method = beanClass.getMethod(setMethodName, fieldValue.getClass());
        if (method != null) {
            obj = method.invoke(obj, fieldValue);
        }
        return obj;
    }

    /**
     * 反射获得值(直接反射字段取值)
     * @param obj
     * @param fieldName
     * @return
     * @throws Exception
     */
    public static Object getFieldValueD(Object obj, String fieldName) throws Exception {
        if (obj == null || StringUtils.isBlank(fieldName)) {
            return obj;
        }
        Class beanClass = obj.getClass();
        do {
            Field[] fs = beanClass.getDeclaredFields();
            for (int i = 0; i < fs.length; i++) {
                Field f = fs[i];
                //设置些属性是可以访问的
                f.setAccessible(true);
                //得到此属性的值
                Object objVal = f.get(obj);
                if (f.getName().equals(fieldName)) {
                    return objVal;
                }
            }
            beanClass = beanClass.getSuperclass();
        } while (beanClass != null);
        return null;
    }

    /**
     * 反射设置值(直接给字段赋值)
     * @param obj
     * @param fieldName
     * @param fieldValue
     * @return
     */
    public static Object setFieldValueD(Object obj, String fieldName, Object fieldValue) throws Exception {
       if (obj == null || StringUtils.isBlank(fieldName)) {
           return obj;
       }
       Class beanClass = obj.getClass();
       do {
           Field[] fs = beanClass.getDeclaredFields();
           for (int i = 0; i < fs.length; i++) {
               Field f = fs[i];
               //设置些属性是可以访问的
               f.setAccessible(true);
               if (f.getName().equals(fieldName)) {
                   f.set(obj, fieldValue);
                   return obj;
               }
           }
           beanClass = beanClass.getSuperclass();
       } while (beanClass != null);
       return obj;
    }
}
















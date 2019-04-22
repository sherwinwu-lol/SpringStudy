package impl.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class FileUtil {
    public static final String PREFIX = "D:\\SpringStudy\\salary-payment-base\\src\\main\\resources\\";
    public static final String SUFFIX = ".json";

    public static Object parseJSONToObject(String filePath) throws Exception {
        filePath = PREFIX + filePath + SUFFIX;
        File file = new File(filePath);
        String content = FileUtils.readFileToString(file, "UTF-8");
        JSONObject jsonObject = JSON.parseObject(content);
        String className = jsonObject.getString("className");
        Class<? extends Object> tClass = Class.forName(className);
        Object t = JSON.parseObject(content, tClass);
        return t;
    }
}

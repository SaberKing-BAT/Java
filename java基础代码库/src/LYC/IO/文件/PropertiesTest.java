package LYC.IO.文件;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName PropertiesTest
 * @Description TODO
 * @Author LYC
 * @Date 2020/5/27 15:17
 * @Version 1.0
 **/
public class PropertiesTest {
    public static String getMainpath() {
        Properties properties = new Properties();
        //读取webResource下的文件
        InputStream stream = PropertiesTest.class.getClassLoader().getResourceAsStream("ExportSQLDataConfig.properties");
        // ClassLoader.getSystemResourceAsStream("ExportSQLDataConfig.properties");web项目启动的话，就有点问题了
        //一直获取不到具体的地址，抛出一个null，
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = properties.getProperty("mainPath");
        System.out.println(value);
        return value;
    }
}

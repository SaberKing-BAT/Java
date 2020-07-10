package LYC.IO.文件;

import java.io.File;

/**
 * @ClassName FileTest
 * @Description TODO
 * @Author LYC
 * @Date 2020/5/22 15:01
 * @Version 1.0
 **/
public class FileTest {
    public static void main(String[] args) {
        createPath("D:\\bv\\vn");
        fileSuffix("test.java");
    }
    //获取文件后缀
    public static String fileSuffix(String file){
        System.out.println(file);
        String suffix =  file.split("\\.")[1];
        System.out.println(suffix);
        return suffix;
    }

    //检测创建目录
    public static void createPath(String filePath){
        //filePath = "D:\\bv\\vn";
        File file = new File(filePath);
        if(!file.exists()){
            System.out.println("目录不存在！");
            file.mkdirs();
            System.out.println("目录已经创建！");
        }
    }
}

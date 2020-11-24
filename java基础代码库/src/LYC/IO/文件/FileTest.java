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
        test3();
       // createPath("D:\\bv\\vn");
      // fileSuffix("test.java");
        //deleteFile("D:\\txt1.txt");
       // removeFile("D:\\ccfTojson\\originalPath\\remove.txt","D:\\ccfTojson\\backupPath\\remove.txt");
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
    //文件删除
    public static boolean deleteFile(String path){
        File file=new File(path);
        boolean flag= file.delete();
        System.out.println(flag);
        return flag;
    }
    //文件移动
    public static boolean removeFile(String oldPath,String newPath){
        File file =new File(oldPath);
        File newFile = new File(newPath);
        boolean flag=file.renameTo(newFile);
        System.out.println(flag);
        return flag;
    }
    public static void test3(){
        String path1="D:/";
        System.out.println(path1);
    }
}

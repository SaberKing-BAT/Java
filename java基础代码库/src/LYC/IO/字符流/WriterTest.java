package LYC.IO.字符流;

import LYC.IO.文件.FileTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @ClassName WriterTest
 * @Description 带缓存和不带缓存两种方式写入文件
 * @Author LYC
 * @Date 2020/5/21 17:28
 * @Version 1.0
 **/
public class WriterTest {
    public static void main(String[] args) {
        writer();
    }

    //不带缓冲
    public static void writer(){
        String filePath = "D:\\files\\file1";
        String fileName = "test.txt";
        String fileInfo="我是大好人";
        FileTest.createPath(filePath);
        try {
            File file=new File(filePath+fileName);
            Writer writer =new FileWriter(file);
            writer.write(fileInfo);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //带缓冲
    public static void bufferWriter() {

    }
}

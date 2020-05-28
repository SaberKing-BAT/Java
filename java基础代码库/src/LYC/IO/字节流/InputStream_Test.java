package LYC.IO.字节流;

import java.io.*;

public class InputStream_Test {
    public static void main(String[] args) throws IOException {
        fileInputStream();
        bufferInputStream();
    }
    // 使用FileInputStream读取
    public static void fileInputStream() throws IOException {
        String filepath="D:\\study\\idea_workspace\\java基础代码库\\file\\字节流1.txt";
        File file = new File(filepath);
        InputStream in= new FileInputStream(file);
        byte[] bytes =new byte[(int)file.length()];
        in.read(bytes);
        in.close();
        System.out.println(new String(bytes));//为什么字节流可以读取Unicode 255以上的汉字？？
    }
    // 使用带缓冲区的BufferInputStream读取
    public static void bufferInputStream() throws IOException {
        String filepath="D:\\study\\idea_workspace\\java基础代码库\\file\\字节流1.txt";
        File file = new File(filepath);
        InputStream inputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bytes = new byte[(int)file.length()];
        bufferedInputStream.read(bytes);
        bufferedInputStream.close();
        System.out.println(new String(bytes));
    }
}
/*
 BufferedInputStream是带缓冲区的输入流，默认缓冲区大小是8M，
 能够减少访问磁盘的次数，提高文件读取性能；
 BufferedOutputStream是带缓冲区的输出流，能够提高文件的写入效率。
 BufferedInputStream与BufferedOutputStream分别是FilterInputStream类
 和FilterOutputStream类的子类，
 实现了装饰设计模式。

* */
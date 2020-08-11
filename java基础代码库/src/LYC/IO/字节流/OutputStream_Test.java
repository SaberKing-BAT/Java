package LYC.IO.字节流;


import java.io.*;

public class OutputStream_Test {
    public static void main(String[] args) throws IOException {
        outPutStream();
        //bufferOutputStream();
    }
    public static void outPutStream() throws IOException {
        String fliePath="D:\\t1.txt";
        File file = new File(fliePath);//没有会创建
        OutputStream outputStream = new FileOutputStream(file);
        byte[] bytes= "hello".getBytes();
        outputStream.write(bytes);
        outputStream.close();
    }
    //使用带缓存区的
    public static void bufferOutputStream() throws IOException {
        String fliePath="D:\\study\\idea_workspace\\java基础代码库\\file\\字节流输出1.txt";
        File file = new File(fliePath);
        OutputStream outputStream = new FileOutputStream(file,true);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] bytes = new String("wangbada啊").getBytes();
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();//不关闭写不进去
    }
}

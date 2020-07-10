package LYC.IO.字符流;

import java.io.*;

public class ReaderTest {
    public static void main(String[] args) throws IOException {
        reader();
        //bufferReader();
    }
    //不带缓冲池
    public static void reader() throws IOException {
        String filepath="D:\\bugData.json";
        File file = new File(filepath);
        Reader reader = new FileReader(file);
        char[] chars=new char[(int)file.length()];
        System.out.println(file.length());
        int read = reader.read(chars);
        reader.close();
        String str = new String(chars);
        System.out.println(new String(chars,0,read).length());
        System.out.println(new String(chars).length());
        System.out.println(str);
    }

    //带缓冲池
    public static void bufferReader() throws IOException {
        String filepath="D:\\study\\idea_workspace\\java基础代码库\\file\\字节流1.txt";
        File file = new File(filepath);
        Reader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        char[] chars = new char[1024];
        bufferedReader.read(chars);
        bufferedReader.close();
        String str= new String(chars);
//        byte[] bytes= str.getBytes("GB2312");
//        String UTF8Str= new String(bytes,"utf-8");
//        System.out.println(UTF8Str);
    }
}

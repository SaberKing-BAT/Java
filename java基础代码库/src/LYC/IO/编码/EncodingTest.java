package LYC.IO.编码;

import LYC.IO.字符流.WriterTest;

import java.io.UnsupportedEncodingException;

public class EncodingTest {
    public static void ecoding() throws UnsupportedEncodingException {
        String str= "{flag:1,msg:\"����json�ļ��ɹ�!\"}";   //这个使用utf-8编码得到的字符串
        byte[] bytes = str.getBytes("utf-8");      //还原Unicode字节
        String str1 = new String(bytes,"Unicode"); //
        System.out.println(str1);
        byte[] bytes2 = str.getBytes("Unicode");
        String str2 = new String(bytes2,"utf-8");
        System.out.println(str2);

    }
    public  static  void test2() throws UnsupportedEncodingException {
        String str="{flag:1,msg:\"生成json文件成功!\"}";
        byte[] bytes =str.getBytes("Unicode");
        String str1= new String(bytes,"Unicode");
        WriterTest.writer(str1);
        System.out.println(str1);
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        //ecoding();
        test2();
    }
}

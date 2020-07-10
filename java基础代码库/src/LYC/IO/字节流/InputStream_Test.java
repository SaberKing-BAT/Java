package LYC.IO.字节流;

import LYC.IO.字符流.WriterTest;

import java.io.*;

public class InputStream_Test {
    public static void main(String[] args) throws IOException {
        //fileInputStream("D:\\bugData.json");
        bufferInputStream("D:\\bugData.json");
      //  Test();
    }
    public static void Test() throws UnsupportedEncodingException {
        String str= "你好啊";
        byte[] bytes=str.getBytes();
        for(byte b:bytes){
            System.out.println(b);
            System.out.println(Integer.toHexString(b));
        }
        String str1=new String(bytes,"gb2312");
        WriterTest.writer(str1);
        System.out.println(str1);
    }

    // ʹ��FileInputStream��ȡ
    public static void fileInputStream( String filename) throws IOException {
        File file = new File(filename);
        InputStream in= new FileInputStream(file);
        byte[] bytes =new byte[(int)file.length()];
        in.read(bytes);
        in.close();
        String str =new String(bytes,"utf-8");
        System.out.println(str);
        System.out.println(new String(bytes));//Ϊʲô�ֽ������Զ�ȡUnicode 255���ϵĺ��֣���
    }

    public static void bufferInputStream(String filepath) throws IOException {
       // String filepath="D:\\txt1.txt";
        File file = new File(filepath);
        InputStream inputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bytes = new byte[(int)file.length()];
        bufferedInputStream.read(bytes);
        bufferedInputStream.close();
        System.out.println(new String(bytes,"gb2312"));
    }
}
/*
 BufferedInputStream�Ǵ�����������������Ĭ�ϻ�������С��8M��
 �ܹ����ٷ��ʴ��̵Ĵ���������ļ���ȡ���ܣ�
 BufferedOutputStream�Ǵ�����������������ܹ�����ļ���д��Ч�ʡ�
 BufferedInputStream��BufferedOutputStream�ֱ���FilterInputStream��
 ��FilterOutputStream������࣬
 ʵ����װ�����ģʽ��

* */
package LYC.IO.文件;

import java.io.File;

public class FileTraverse {
    public static void traverse() throws InterruptedException {
        File file = new File("D:\\study\\Java\\java基础代码库\\src\\LYC\\IO\\文件");
        for (String filename:file.list()
             ) {
            System.out.println(filename);
        }
        int i=1;
        while(true){
            System.out.println(i);
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        traverse();
    }
}

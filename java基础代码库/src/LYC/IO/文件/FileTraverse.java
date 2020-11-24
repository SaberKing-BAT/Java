package LYC.IO.文件;

import java.io.File;

public class FileTraverse {
    public static void traverse() throws InterruptedException {
        File file = new File("D:/study");
        for (String filename:file.list()
             ) {
            System.out.println(filename);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        traverse();
    }
}

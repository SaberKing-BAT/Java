package LYC.IO.文件;

import java.io.File;
import java.sql.Blob;

public class FileImg {
    Blob blob;
    String basePath= this.getClass().getResource("").getPath();
    public void imgToBinaryFile(){
        File img= new File(basePath+"/草莓.jpg");

    }
    public void binaryFileToImg(){

    }
    public static void main(String[] args) {
        System.out.println(new FileImg().basePath);
    }
}

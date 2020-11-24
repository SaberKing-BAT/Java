package LYC.lang.Runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WindCMD_Test2 {
    public  static void test1() throws IOException {
       // String cmd="cmd /k start C:\\Users\\22069\\Desktop\\服务质量数据导出包\\服务质量数据导出包\\GSMROutData.exe \"C:\\Users\\22069\\Desktop\\服务质量数据导出包\\服务质量数据导出包\\成灌线_下行_CRH380AJ-2808_服务质量_20200425.gsmr\" \"C:\\Users\\22069\\Desktop\\服务质量数据导出包\\服务质量数据导出包\"";
        String cmd="cmd /k start osk";
        Process p=Runtime.getRuntime().exec(cmd);
    }
    public  static void  test2(){
        try {
            String cmd = "ping ";
            String param ="127.0.0.1";
            String zcmd=" C:\\Users\\22069\\Desktop\\服务质量数据导出包\\服务质量数据导出包\\GSMROutData.exe \"C:\\Users\\22069\\Desktop\\服务质量数据导出包\\服务质量数据导出包\\成灌线_下行_CRH380AJ-2808_服务质量_20200425.gsmr\" \"C:\\Users\\22069\\Desktop\\服务质量数据导出包\\服务质量数据导出包\"\n";
            Process child = Runtime.getRuntime().exec(zcmd);
            // 获得ping的输出
            InputStream child_in = child.getInputStream();
            int c;
            while ((c = child_in.read()) != -1) {
                //   System.out.println("kkk");
                System.out.print((char)c);
            }
            child_in.close();
        } catch (IOException e) {
            System.err.println(e);
        }

    }
    public static void test3(){
        ProcessBuilder processBuilder = new ProcessBuilder("cmd","/c","D:\\fwzl\\exepath\\GSMROutData.exe \"D:\\fwzl\\exepath\\成灌线_下行_CRH380AJ-2808_服务质量_20200425.gsmr\" \"D:\\fwzl\\exepath\"\n");
        Process process=null;
        try {
            process = processBuilder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line;
            while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    if ("1".equals(line))
                        break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            process.destroy();
        }
    }
    public static void main(String[] args) throws IOException {
        //test1();
        test3();
    }

}

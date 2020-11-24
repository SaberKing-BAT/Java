package LYC.lang.Runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class WindCMD_Test {
    public static void run() {
        Runtime runtime = Runtime.getRuntime();
       String cmd=" C:\\Users\\22069\\Desktop\\服务质量数据导出包\\服务质量数据导出包\\GSMROutData.exe \"C:\\Users\\22069\\Desktop\\服务质量数据导出包\\服务质量数据导出包\\成灌线_下行_CRH380AJ-2808_服务质量_20200425.gsmr\" \"C:\\Users\\22069\\Desktop\\服务质量数据导出包\\服务质量数据导出包\"";
       // String cmd="cmd /k start dir";
        System.out.println(cmd);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(runtime.exec(cmd).getInputStream(),"GB2312"));
            //StringBuffer b = new StringBuffer();
            String line=null;
            StringBuffer b=new StringBuffer();
            while ((line=br.readLine())!=null) {
                b.append(line+"\n");
            }
            System.out.println(b.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        WindCMD_Test delp = new WindCMD_Test();
        delp.run();
    }

}

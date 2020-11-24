package LYC.lang.Runtime;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Fwzl {
    /*
     * @Author: LYC
     * @Date: 2020/11/10 15:09
     * @Param: []
     * @return: void
     * @TODO: 扫描文件(成灌线_下行_CRH380AJ-2808_服务质量_20200425)并解析入库
     **/
    private void scanFileTask(){
        String scanPathStr=getPropertiesValue("scanpath");
        File scanPath=new File(scanPathStr);
        for (int i=0;i<scanPath.list().length;i++){
            String fileName=scanPath.list()[i];
            String fileNamePrefix  = fileName.split(".")[0];
            String fileNameSuffix=fileName.split(".")[1];
            if ("gsmr".equals(fileNameSuffix)){
                //调用解析入库方法
                boolean flag=geneateExcelFile(scanPathStr+"\\"+fileName);
                if (flag){
                    //调用解析Excel的方法
                }
            }
        }
    }
    private void paringExcel(String excelpath,String excelName){

    }
    /*
     * @Author: LYC
     * @Date: 2020/11/10 15:07
     * @Param: [gmsrFile]
     * @return: boolean
     * @TODO: 调用exe 解析gmsr生成excel
     **/
    private boolean geneateExcelFile(String gmsrFile){
        boolean flag=false;
        ProcessBuilder processBuilder = new ProcessBuilder("cmd","/c",getPropertiesValue("exepath")+" \""+gmsrFile+"\" \""+getPropertiesValue("excelpath")+"\"");
        Process process=null;
        try {
            process = processBuilder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if (!"0".equals(line))
                    break;
            }
            if ("1".equals(line))
                flag= true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            process.destroy();
            return flag;
        }
    }

    /*
     * @Author: LYC
     * @Date: 2020/11/10 14:14
     * @Param: [key]
     * @return: java.lang.String
     * @TODO: 读取properties配置文件
     **/
    private String getPropertiesValue(String key){
        InputStream in=null;
        try {
            in= new BufferedInputStream(new FileInputStream("jar_config.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties p=new Properties();
        try {
            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p.getProperty(key);
    }
    /*
     * @Author: LYC
     * @Date: 2020/11/10 14:15
     * @Param: []
     * @return: void
     * @TODO: 定时器方法
     **/
    private void timer(){
        int startTime=Integer.parseInt(getPropertiesValue("startTime"));
        int intervalTime=Integer.parseInt(getPropertiesValue("intervalTime"));
        //执行器线程
        Runnable r=new Runnable() {
            @Override
            public void run() {
                //服务质量数据解析入库任务
                scanFileTask();
            }
        };
        //定时调度配置
        ScheduledExecutorService service= Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(r,startTime,intervalTime, TimeUnit.SECONDS);
    }
    public static void main(String[] args) {
       new Fwzl().timer();
    }
}
/*
 * 一、定时器
 * 二、文件扫描
 * 三、解析入库
 */
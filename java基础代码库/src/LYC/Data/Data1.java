package LYC.Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data1 {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        System.out.println("1.年: " + now.get(Calendar.YEAR));
        System.out.println("2.月: " + (now.get(Calendar.MONTH) + 1) + "");
        System.out.println("3.日: " + now.get(Calendar.DAY_OF_MONTH));
        System.out.println("4.时: " + now.get(Calendar.HOUR_OF_DAY));
        System.out.println("5.分: " + now.get(Calendar.MINUTE));
        System.out.println("6.秒: " + now.get(Calendar.SECOND));
        System.out.println("7.当前时间毫秒数：" + now.getTimeInMillis());
        System.out.println("8."+now.getTime());
        long l = System.currentTimeMillis();
        System.out.println("9."+l);
        Date d = new Date();
        System.out.println("10."+d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        System.out.println("11.格式化后的日期：" + dateNowStr);
    }

}

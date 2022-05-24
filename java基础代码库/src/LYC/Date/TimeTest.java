package LYC.Date;


import com.alibaba.fastjson.JSON;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {
    public static void test1() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        Date uDate=sdf.parse("22:22:22");
        System.out.println(uDate);
                /*sql.Time*/
        Time time=new Time(new Date().getTime());
        System.out.println(time);
                /*sql.Date*/
        java.sql.Date date=new java.sql.Date(new Date().getTime());
        System.out.println(date);
    }
    public static void main(String[] args) throws ParseException {
      //  test1();
        String []strs={"12","34"};
        System.out.println(JSON.toJSONString(strs));
    }
}

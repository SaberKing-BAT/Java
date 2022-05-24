package LYC.反射.操作类;

import com.sun.jna.WString;

import java.lang.reflect.Field;
import java.util.Locale;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException {
        Class clazz=Person.class;

        Field field=clazz.getDeclaredField("money");
        System.out.println(field.getType().getName().toString());
        String str="Name";
        System.out.println(str.toLowerCase(Locale.ROOT));
        String date="2020-12-12";
        String date2="2020年12月12日";
        WString str1=null;


    }
}

package LYC.集合.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static Map test1(int n){
        Map map =new HashMap();
        if (n==0)
            return null;
        else
            return map;
    }
    public static void main(String[] args) {
//        System.out.println(test1(0));
//        System.out.println(test1(1));
        ArrayList<String > arrayList=new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        String [] strings={"1","2"};
        System.out.println(arrayList.toString());
        System.out.println(strings.toString());
    }
}

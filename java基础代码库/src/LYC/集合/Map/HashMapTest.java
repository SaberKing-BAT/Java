package LYC.集合.Map;

import LYC.数据类型.Bigdecimal_Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {
    public static Map test1(int n){
        Map map =new HashMap();
        if (n==0)
            return null;
        else
            return map;
    }

    /*
    *  利用object 做不同类型间的转换是很危险的，如果两个类型彼此不支持强转，将导致两姓家奴，无家可归(44-46行)；
    *  一个类型虽然转成了object ，但是还是属于自身类型
    */
    public static void test2(){
        List<Map<String,String>> list1=new ArrayList<>();//null;
        List<Map<String,Object>> list2=new ArrayList<>();
        List list3;
        Map<String,String> map1=new HashMap<>();
        Map<String,Object> map2=new HashMap<>();
       // list1.add(map1);
        // list1.add(map2);   //报错，识别了不同类型的map
        map2.put("n",new BigDecimal("123"));
        list2.add(map2);
        list3=list2;
        list1=list3;
        Object obj=list1.get(0).get("n");
        BigDecimal bigDecimal=new BigDecimal("123");
        System.out.println(bigDecimal);

        //System.out.println(list1.get(0) instanceof HashMap<String,Object>);
        System.out.println("是否是obj："+(list1.get(0).get("n") instanceof Object));
        System.out.println("是否是Bigdecimal："+(obj instanceof BigDecimal));
        System.out.println("是否是String："+(list1.get(0).get("n") instanceof String));
     //   BigDecimal bigDecimal1=(BigDecimal) list1.get(0).get("n"); //编译报错类型检测，假到真时，真亦假  666！
        String str=list1.get(0).get("n");  //运行报错，java泛型检查只在编译期有效
        System.out.println(str);
    }
    public void test3(){
        /*
            局部变量可以先声明，后赋初始值，但不可以不赋值
        * */
//        List list;
//        int i;
//        if (i>0){}
    }
    public static void main(String[] args) {
        test2();
    }
}

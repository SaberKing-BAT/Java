package LYC.集合.LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @ClassName SortTest
 * @Description TODO
 * @Author LYC
 * @Date 2020/6/29 9:21
 * @Version 1.0
 **/
public class SortTest {
    public static void toHashMap1(){
        LinkedHashMap<String,String> linkedHashMap =new LinkedHashMap();
        linkedHashMap.put("1","1");
        linkedHashMap.put("2","2");
        linkedHashMap.put("3","3");
        linkedHashMap.remove("3");
        HashMap<String,String> hashMap=linkedHashMap;
        for (String key:hashMap.keySet()
        ) {
            System.out.println("key= "+ key + " and value= " + hashMap.get(key));
        }
    }
    //继承了HashMap，子类转父类，向上转型
    public static void toHashMap2(){
        HashMap<String,String> linkedHashMap =new LinkedHashMap();
        LinkedHashMap<String,String> linkedHashMap2 =new LinkedHashMap();
        linkedHashMap.put("1","1");
        linkedHashMap.put("2","2");
        linkedHashMap.put("3","3");
        linkedHashMap2.putAll(linkedHashMap);
        HashMap<String,String> hashMap=linkedHashMap;
        for (String key:hashMap.keySet()
        ) {
            System.out.println("key= "+ key + " and value= " + hashMap.get(key));
        }
        for (String key:linkedHashMap2.keySet()
        ) {
            System.out.println("key= "+ key + " and value= " + linkedHashMap2.get(key));
        }
        System.out.println(linkedHashMap.size());
    }
    //测试有序，值覆盖，key = null
    public static void sort(){
        LinkedHashMap<String,String> linkedHashMap =new LinkedHashMap();
        linkedHashMap.put("","");
        linkedHashMap.put("1","1");
        linkedHashMap.put(null,"");
        linkedHashMap.put("2","2");
        linkedHashMap.put(null,"213");
        for (String key:linkedHashMap.keySet()
             ) {
            System.out.println("key= "+ key + " and value= " + linkedHashMap.get(key));
        }
    }
    public static void main(String[] args) {

//        sort();
        toHashMap1();
//        toHashMap2();
    }
}

package LYC.集合.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UpdateMap
 * @Description 浅拷贝问题，对象的对象不能被复制，这是复制了一个
 * @Author LYC
 * @Date 2020/6/16 16:43
 * @Version 1.0
 **/
public class UpdateMap {
    public static void  updateMap(Map<String,String> map){
        map.put("5","已经被修改");
        System.out.println(map.hashCode());
        System.out.println(map.get("1").hashCode());
    }
    public static  void clonMap(){
        HashMap<String,String> map =new HashMap<>();
        map.put("1","1");
        HashMap<String,String> map1=map;
        map1.put("2","2");
        HashMap<String,String> map2 =new HashMap<>();
        map2.putAll(map);
        map2.put("3","3");
        HashMap<String,String> map3= (HashMap<String, String>) map.clone();
        map3.put("4","4");
        updateMap(map);
        System.out.println("map:");
        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }
        System.out.println("map1:");
        for (String key : map1.keySet()) {
            System.out.println("key= "+ key + " and value= " + map1.get(key));
        }
        System.out.println("map2:");
        for (String key : map2.keySet()) {
            System.out.println("key= "+ key + " and value= " + map2.get(key));
        }
        System.out.println("map3:");
        for (String key : map3.keySet()) {
            System.out.println("key= "+ key + " and value= " + map3.get(key));
        }
        System.out.println("map:");
        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }
    }
    public static void main(String[] args) {

        clonMap();
    }
}

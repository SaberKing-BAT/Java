package LYC.集合.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName Traverse
 * @Description TODO
 * @Author LYC
 * @Date 2020/6/15 14:55
 * @Version 1.0
 **/
public class Traverse {
    Map<String, String> map=null ;
    public void  initMap(){
        map=new HashMap<>();
        for (int i=0;i<1000000;i++){
            map.put(String.valueOf(i),String.valueOf(i));
        }
    }
    //第一种：普遍使用，二次取值
    public void keySet(){
        System.out.println("通过Map.keySet遍历key和value：");    //350-430ms
        long startTime =System.currentTimeMillis();
        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }
        long endTime=System.currentTimeMillis();
        long useTime=endTime-startTime;
        System.out.println("总用时："+useTime);
    }
    //第二种:通过Iterator迭代器遍历循环Map.entrySet().iterator();
    public void Iterrator(){
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        long startTime =System.currentTimeMillis();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        long endTime=System.currentTimeMillis();
        long useTime=endTime-startTime;
        System.out.println("总用时："+useTime);
    }

    //第三种：笔者推荐，尤其是容量大时(相对来说 比2好一点 效率高)
    public void entrySet(){
        System.out.println("通过Map.entrySet遍历key和value");
        long startTime =System.currentTimeMillis();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        long endTime=System.currentTimeMillis();
        long useTime=endTime-startTime;
        System.out.println("总用时："+useTime);
    }
    //第四种
    public void mapValues(){
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
    }

    public static void main(String[] args) {
        Traverse traverse=new Traverse();
        traverse.initMap();    //10w           100w
       traverse.keySet();    //350-430          3500ms
//        traverse.Iterrator();    //350-400         3300-3800ms
//        traverse.entrySet();   //350-440            3300ms
//        traverse.mapValues();

    }
}

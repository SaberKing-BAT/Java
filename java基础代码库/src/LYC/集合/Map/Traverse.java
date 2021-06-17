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
        for (int i=0;i<100000;i++){
            map.put(String.valueOf(i),String.valueOf(i));
        }
    }
    //第一种：普遍使用，二次取值
    public void keySet(){
        System.out.println("通过Map.keySet遍历key和value：");
        long startTime =System.currentTimeMillis();
        for (String key : map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }
        long endTime=System.currentTimeMillis();
        long useTime=endTime-startTime;
        System.out.println("总用时："+useTime);
    }

    public void Iterrator(){

    }


    public static void main(String[] args) {
        // 构建一个Map 初始值为3条数据
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "xiaqiu");
        map.put("2", "pangzi");
        map.put("3", "shouzi");



        //第二种:通过Iterator迭代器遍历循环Map.entrySet().iterator();
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第三种：笔者推荐，尤其是容量大时(相对来说 比2好一点 效率高)
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第四种
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
    }
}

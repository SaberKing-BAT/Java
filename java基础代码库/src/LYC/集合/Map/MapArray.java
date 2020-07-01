package LYC.集合.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapArray
 * @Description FastJson应用，官方文档：https://github.com/alibaba/fastjson
 * @Author LYC
 * @Date 2020/6/16 10:24
 * @Version 1.0
 **/
public class MapArray {
    public static void mapToJson(){
        Map map=new HashMap<String,String>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        String str = JSON.toJSONString(map);
        System.out.println(str);
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject.get("1"));

    }
    public void mapsToJson(){
        Map[] maps = new HashMap[5];
        maps[0]=new HashMap();
        maps[0].put("1","1");
        maps[0].put("2","2");
        maps[1]=new HashMap();
        maps[1].put("1","1");
        maps[1].put("2","2");
        //JSONArray jsonArray = JSONArray.toJSON(maps);
        //String str1=jsonObject.toJSONString();
        //System.out.println(str1);
        String str = JSON.toJSONString(maps);
        //  JSONObject jsonObject = JSONObject.parse();
        JSONArray jsonArray = JSONArray.parseArray(str);
        String str2 = jsonArray.toJSONString();
        System.out.println(str2);
        System.out.println(str);
    }
    public static void main(String[] args) {
        mapToJson();
    }
}

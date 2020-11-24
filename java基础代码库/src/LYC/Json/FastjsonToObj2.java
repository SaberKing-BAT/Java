package LYC.Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public class FastjsonToObj2 {
    static String test() {
        String jsonstr = "[{\"F_ID\":\"123\",\"F_LC\":\"123\"},{\"F_ID\":\"123\",\"F_LC\":\"123\"}]";
        JSONArray jsonArray = JSON.parseArray(jsonstr);
        JSONArray newJsonArray=new JSONArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jobj = jsonArray.getJSONObject(i);
            JSONObject jobj2=new JSONObject();
            for (Map.Entry<String, Object> entry : jobj.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                char cs[]=key.toCharArray();
                for (int j=0;j<cs.length;j++) {
                    if (Character.isUpperCase(cs[j])&&j!=2 ){
                        cs[j]= Character.toLowerCase(cs[j]);
                    }
                }
                key=String.valueOf(cs).replace("_","");
                jobj2.put(key,value);
            }
            newJsonArray.add(jobj2);
        }
        String newJsonStr=newJsonArray.toJSONString();
        System.out.println(newJsonStr);
        List<A> list=JSON.parseArray(newJsonStr,A.class);
        for (A a:list
             ) {
            System.out.println(a);
        }
        return  newJsonStr;
    }


    public static void main(String[] args) {
        test();
    }


}

class A {
    String fId;
    String fLc;

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }

    public String getfLc() {
        return fLc;
    }

    public void setfLc(String fLc) {
        this.fLc = fLc;
    }

    @Override
    public String toString() {
        return "A{" +
                "fId='" + fId + '\'' +
                ", fLc='" + fLc + '\'' +
                '}';
    }
}
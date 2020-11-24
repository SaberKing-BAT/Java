package LYC.Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * @ClassName TestFastJson
 * @Description TODO
 * @Author LYC
 * @Date 2020/6/15 16:29
 * @Version 1.0
 **/
public class TestFastJson {
    //封装json字符串；
    public static String packagingJson(){
        JSONObject jsonObject = new JSONObject();
        JSONArray in = new JSONArray();
        JSONObject in1 =new JSONObject();
        JSONObject in2 =new JSONObject();
        JSONObject value =  new JSONObject();
        value.put("1","1");
        value.put("2","2");
        value.put("3","3");
        in1.put("value",value);
        in1.put("type","2002");
        in2.put("value","03");
        in2.put("type","12");
        in.add(in1);
        in.add(in2);
        JSONArray out = new JSONArray();
        JSONObject out1 = new JSONObject();
        JSONObject out2 =new JSONObject();
        out1.put("outName","PRM_KF");
        out1.put("outType","2");
        out2.put("outName","PRM_KF");
        out2.put("outType","2");
        out.add(out1);
        out.add(out2);
        jsonObject.put("in",in);
        jsonObject.put("out",out);
        jsonObject.put("procedureName","PKG_SBPJ_DYHF.PRO_DYHF_MAIN");
        String str = jsonObject.toJSONString();
        System.out.println(str);
        return  str;
    }
    //解析json
    public static String analysisJson(){
        String str = "{" +
                "\"code\": 0," +
                "\"msg\": \"操作成功\"," +
                "\"data\": {" +
                "\"PRM_WXJY\": null," +
                "\"PRM_KF\": null," +
                "\"PRM_MSG\": null," +
                "\"PRM_TQIKFBZW\": \"1\"," +
                "\"PRM_CODE\": \"1\"" +
                "}" +
                "}";
        System.out.println(str);
        JSONObject jsonObject =JSONObject.parseObject(str);
        JSONObject data = jsonObject.getJSONObject("data");
        //get方法返回Object，返回具体可以用getString等
        System.out.println(data.get("PRM_CODE").toString());
        int i = Integer.parseInt((String) data.get("PRM_CODE")) ;
        System.out.println(i);
        int a = data.getInteger("PRM_CODE");
        System.out.println(a);
        String str1 = data.getString("PRM_CODE");
        System.out.println(str1);
        //注意Json中的数字类型是Number包装类类型，
        Number number =new Integer(2312);
        number.toString();

        //

        return "";
    }

    /*
        关于转移字符和路径问题
        1.在纯额json文件中路径：D:\A\B
        2.java中D:\\A\\B==D:\A\B
        3.所以需要String str=D:\\\\A\\\\B
        4.字符串转移一次变\\,fastjson中在转移一次剩\
        5.如果只用\\ key:value    那么String value="D:\A\B"是不行的
        6.总结 json的字符串是包了两层的，所以需要两层转义。 json = "{"key":"value"}"，字符串里的字符串。。
        7.在replaceAll中为了表示两个需要\\\\,多了一层表面的转义
     */
    public static void zhuanyi(){
        String str = "{\"1\":\"D:\\你啊\\你安抚\\4\"}";
        System.out.println(str);
        str=str.replaceAll("\\\\","\\\\\\\\");
        System.out.println(str);
        JSONObject jsonObject =JSON.parseObject(str);
        System.out.println(jsonObject.getString("1"));
    }
    public static void test(){
        String str="{\n" +
                "\t\"code\":1,\n" +
                "\t\"message\":\"成功\",\n" +
                "\t\"data\":{\n" +
                "\t\t\"mileage\":5.64,\n" +
                "\t\t\"channelList\": [\"LACC\", \"VACC\"],\n" +
                "\t\t\"dataMap\": {\n" +
                "\t\t\t\"LACC1\":[1,-1,2,-2,3,-3,4],\n" +
                "\t\t\t\"LACC2\":[1,-1,2,-2,3,-3,4]\n" +
                "\t\t},\n" +
                "\t\t\"mileageList\":[1,2,3,4,5,6,7,]\n" +
                "\t}\n" +
                "}";
        JSONObject jsonObject=new JSONObject(JSON.parseObject(str));
        System.out.println(str);
    }
    public static void main(String[] args) {
       // boolean flag = 1>2;
        //System.out.println(flag);
       // analysisJson();
       // packagingJson();
        //zhuanyi();
        test();
    }
}


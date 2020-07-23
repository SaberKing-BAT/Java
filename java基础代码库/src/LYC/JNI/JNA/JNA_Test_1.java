package LYC.JNI.JNA;

import LYC.IO.字符流.WriterTest;
import LYC.IO.字节流.InputStream_Test;
import LYC.string.RemoveSymbol;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.org.apache.bcel.internal.util.ClassPath;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class JNA_Test_1 {
    private interface stdCallDll extends StdCallLibrary {
        String DLLFILE = "D:\\zhongyun_work\\subway project\\ccfToJson\\x64\\CCFToJson";
        stdCallDll INSTANCE = (stdCallDll) Native.load(DLLFILE, stdCallDll.class);

        String MyCCFToJson(String ccfFilePath);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Charset.defaultCharset());
        String file = "D:\\study\\bugData.ccf";
        String res = stdCallDll.INSTANCE.MyCCFToJson(file);
        System.out.println(res);

        byte[] bytes = InputStream_Test.bufferInputStream("D:\\bugData.json");
        String jsonStr = new String(bytes, "gb2312");
        jsonStr = jsonStr.replaceAll("\\\\","\\\\\\\\");
        System.out.println(jsonStr);
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        JSONArray data = jsonObject.getJSONArray("data");
        for (int i=0;i<data.size();i++){
            JSONObject jOb= data.getJSONObject(i);
            String tableName = jOb.getString("tableName");
            System.out.println(tableName);
            JSONArray rows = jOb.getJSONArray("rows");
            //把rows变成对象数组。
            System.out.println(rows);
        }

    }
}

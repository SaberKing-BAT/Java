package LYC.Util;

import java.util.HashMap;
import java.util.UUID;

/**
 * @ClassName GenerateUID
 * @Description java生成唯一32位ID字符串，Oracle中可以用SYS_GUID()函数来代替。
 * @Author LYC
 * @Date 2020/6/15 15:42
 * @Version 1.0
 **/
public class GenerateUID {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        System.out.println(str);
        // 去掉"-"符号  
        String temp=str.substring(0,8)+str.substring(9,13)+str.substring(14,18)+str.substring(19,23)+str.substring(24);
        System.out.println(temp);
        HashMap<String ,String> [] maps;
    }
}

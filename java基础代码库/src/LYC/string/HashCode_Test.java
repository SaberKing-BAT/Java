package LYC.string;

import java.util.HashMap;

public class HashCode_Test {
    public static void main(String[] args) {
        String str="strrrrrrrfsdfsdfsdfsdfsdfsdfsdfsdsdfsdfsdfsdfsdfsdfsdfsfsfsdfsdfsdfs";
        System.out.println(str.hashCode());
        String str1="str";
        HashMap map=new HashMap();
        map.put(str,"2");
        map.put(str1,"3");
        System.out.println(map.get(str));
        System.out.println(map.get(str1));
        System.out.println(str.hashCode());
        System.out.println(str1.hashCode());
        System.out.println(99999999*999999  );
    }
}

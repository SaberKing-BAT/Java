package LYC.string;

public class SplitTest {
    //小数点需要转义
    public static void split(){
        String str = "file.json";
        String[] strings  = str.split("\\.");
        for (String s:strings
             ) {
            System.out.println(s);
        }
    }
    public static void split1(){
        String str = "file json  pp";
        String[] strings  = str.split(" ");
        for (String s:strings
        ) {
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
            split1();
//        split();
    }
}

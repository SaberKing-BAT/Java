package LYC.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveSymbol {
    public static String removeSymbol(String str){
        String dest="";
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(str);
        dest = m.replaceAll("");
        return  dest;
    }
    public static void test(){
        String str = "123\n2112\n1231";
        System.out.println(str);
        str = str.replaceAll("\n","");
        System.out.println(str);
    }
    public static void main(String[] args) {
        String str="";
        System.out.println(str);
        //test();
    }
}

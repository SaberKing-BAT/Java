package LYC.数据类型.类型范围;

/**
 * @ClassName NumberRange
 * @Description 8个基本类型byte、short、int、long；float、double；char；boolean；
 * @Author LYC
 * @Date 2020/6/1 9:26
 * @Version 1.0
 **/
public class NumberRange {
    public void floatTest(){
        byte b = 12;
        short s = 124;
        char c = 12;
        float  f1 =123;         //不报错因为123字面量默认是int行，和float都是4字节
       // float f2 =123.8;        //报错，因为123.8是小数字面量默认double类型，属于向下转型，需要强制转换
       float f3 = (float)113.1;
       float f4=123.8f;
    }
    public static void main(String[] args) {
        byte b= 127;
        b++;
        int i=Integer.MAX_VALUE+1;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(i);
        System.out.println(b);
    }
}
/*
    java四类八种基本数据类型:
        第一类：整型 byte short int long
        第二类：浮点型 float double
        第三类：逻辑型 boolean(它只有两个值可取true false)
        第四类：字符型 char  包装类Character
    大小范围：1字节=8位，最大值+1 变最小值。
            byte（1字节） [-128,127]                2的8次方;因为分正负，所以2的7次方，整数需要-1（2的7次方-1），下同
            short（2字节）[-32768,32767]         6位数
            int（4字节）  [-21 4748 3648，2147483647]   10位数，21亿4千7百万
            long（8字节） [-922 3372 0368 5477 5808,9223372036854775807] 19位数字 922兆（亿亿）
            float（4字节）
            double（8字节）
            boolean（1字节）
            char（2字节）
    特点：
        基本数据类型：在栈中可以直接分配内存的数据是。
        引用数据类型：是数据的引用在栈中，但是他的对象在堆中。
    自动转换(向上转型)：
        byte->short,char -> int -> long
        float -> double
        int -> float
        long -> double
        应用场景1:计算中类型向最大的转换。

        应用场景2：byte，short，char，自动转成int；所以short=123；123默认int类型，不报错。

     强制转型（向下转型，范围和精度溢出）:用括号
     字面量默认类型：整型int，浮点型double，
 */
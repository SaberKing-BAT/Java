package LYC.数据类型.包装类自动拆装箱;

import java.util.Dictionary;
import java.util.Enumeration;

/**
 * @ClassName NumberTest
 * @Description TODO
 * @Author LYC
 * @Date 2020/5/29 15:25
 * @Version 1.0
 **/
public class NumberTest {
    public static void main(String[] args) {

        //new NumberTest().test();
    }
    public void add(Byte b)
    {
        b = b++;
    }
    public void test()
    {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
/*
    1.包装类的值不可变,就像String一样 ，不是改变值，二是指向了新对象的引用
    2.运算时自动拆箱
    3.最大值+1=最小值
 */




}

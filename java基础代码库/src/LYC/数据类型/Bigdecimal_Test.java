package LYC.数据类型;

import java.math.BigDecimal;

public class Bigdecimal_Test {
    static void addNullTest(){
        BigDecimal b1= new BigDecimal("1");
        BigDecimal b2= new BigDecimal("");
        b1=b1.add(b2);
        System.out.println(b1);
    }
    static  void kxjsTest(){
        BigDecimal b = new BigDecimal("12333E8");
        System.out.println(b.toString());
    }
    public static void main(String[] args) {
       // addNullTest();
      kxjsTest();
    }
}

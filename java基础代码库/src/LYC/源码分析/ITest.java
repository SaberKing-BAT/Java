package LYC.源码分析;

import java.util.concurrent.atomic.AtomicInteger;

public class ITest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger();
        int i=1;
        i=i++;
        int j=i++;
        int k=i+ ++i*i++;
        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);
    }
}

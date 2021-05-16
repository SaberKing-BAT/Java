package LYC.源码分析;

public class ITest {
    public static void main(String[] args) {
        int i=1;
        i=i++;
        int j=i++;
        int k=i+ ++i*i++;
        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);
    }
}

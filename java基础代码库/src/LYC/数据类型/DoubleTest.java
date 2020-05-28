package LYC.数据类型;

/**
 * @ClassName DoubleTest
 * @Description TODO
 * @Author LYC
 * @Date 2020/5/22 10:01
 * @Version 1.0
 **/
public class DoubleTest {
    public static void main(String[] args) {
        precisionLose();
    }

    //精度丢失，例如加法中结果小数尾数为3,0的情况下
  public static void precisionLose() {
        double a = 5.12323;
        double b = 0.23230;
        System.out.println(a+b+"\n"+b+"\n"+(a-b));
    }
}

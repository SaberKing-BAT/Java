package LYC.异常.Exception;

public class TryCath_Test {
    static void test1(){
        //不捕获异常，整个程序会终止
      //  System.out.println(1/0);
        try{
            //一个try-catch只能捕获一个异常
            System.out.println(1/0);
            throw  new Exception("未知异常！");
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.err.println("发生异常！");
        }catch (Exception e){
            e.printStackTrace();
        }
        //捕获异常程序后续代码继续执行
        System.out.println("程序继续执行！");
    }
    public static void main(String[] args) {
        test1();
    }
}

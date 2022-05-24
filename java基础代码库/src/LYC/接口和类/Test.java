package LYC.接口和类;

public class Test {
    interface  in1{
         int a=0; //默认 public static final
    }
    class B{
        public static final int a=0;
        public void printHello(){
            System.out.println("hello");
        }
    }
    public static void main(String[] args) {
        System.out.println(in1.a);
        System.out.println(B.a);
        new Test().new B().printHello();
    }
}
//总结：内部类的静态方法，和静态变量，是类方法，类变量，公共的，所以对于外部类来说就是一个静态成员方法或者静态变量
// 所以B.a  可以在作为static的main方法中直接用，就像调用外部类本身的静态变量和方法一样，不用加Test.B.a。

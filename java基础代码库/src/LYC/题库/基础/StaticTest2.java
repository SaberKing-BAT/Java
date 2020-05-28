package LYC.题库.基础;

public class StaticTest2 {
    public static void main(String[] args) {
       // A a = new A();
        A b = new B();
    }
}
class A{
    static {
        System.out.println("父类静态");
    }
    {
        System.out.println("父类普通方法");
    }
    public A(){
        System.out.println("父类构造方法");
    }
}
class B extends A {
    static {
        System.out.println("子类静态");
    }
    {
        System.out.println("普通方法");
    }
    public B() {
        System.out.println("子类构造方法");
    }
}
/*
    1. 先加载父类静态资源
    2. 在加载自己的静态资源
    3. 加载父类
    4. 加载自己
*/


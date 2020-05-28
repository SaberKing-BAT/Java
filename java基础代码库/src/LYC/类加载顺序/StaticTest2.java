package LYC.类加载顺序;

public class StaticTest2 {
    public static void main(String[] args) {
       // A a = new A();
        B b = new B();
        B b2 = new B();
        B b3 = new B();
        System.out.println(b2.x);
        System.out.println(B.y);
    }
}

class A{
    static {
        System.out.println("父类静态代码块");
    }
    {
        System.out.println("父类构造代码块");
    }
    public A(){
        System.out.println("父类构造方法");
    }
}

class B extends A {
    public static int y=0;
    public int x=0;
    static {
        y++;
        System.out.println("子类静态代码块"+y);
    }
    {
        x++;
        y++;
        System.out.println("子类构造代码块"+x);
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
    关于代码块：
    1.局部代码块：方法中(作用，类似for中的变量，用完即销毁，控制变量的生命周期)
    2.构造代码块(类中)：
        1.作用：给当前实例对象的成员变量始化，也可以改变static变量的值。每new一个对象执行一次，因为静态变量是公共的被累加。
        2.原理：编译时会移动到构造函数中，所有内容最前面执行
    3.静态代码块：类中+static
        1.作用：给静态变量初始化。
        2.原理：类的初始化只执行一次（同一个构造器下），所以静态代码块也执行一次，静态变量是所有对象共享的。
*/


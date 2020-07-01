package LYC.函数;

/**
 * @ClassName ConstructFunction
 * @Description TODO
 * @Author LYC
 * @Date 2020/6/12 13:56
 * @Version 1.0
 **/
public class ConstructFunction {
    public ConstructFunction(){
        this("    被调用");
        System.out.println("无参构造函数");

    }
    public ConstructFunction(String str){
        System.out.println("有参构造函数"+str);
    }
    public void test(){
      //  this();
    }
    public static void main(String[] args) {
        ConstructFunction constructFunction = new ConstructFunction();
    }
}
/*
        1，this只可以调用一个构造器，在一个构造器中不能同时调用两个构造器；
        2，必须将你所调用的构造器放在最开始的位置，这也解释了为什么不能在一个构造函数中调用两个构造器，那第二个势必不在最开始位置。
        3，本例中在带有两个参数的构造函数中可以用this调用其他任意一个只有一个参数的构造函数，这取决你自己，随便调哪一个都可以。
        4，在构造函数之外的方法内不能使用this调用构造函数。代码里面注释的都不能正确编译。

 */
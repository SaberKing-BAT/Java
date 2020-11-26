package LYC.反射;

/**
 * 测试类
 */
public class StaticProxy_Test {
    public static void main(String[] args) {
        ProxyClass proxyClass=new ProxyClass(new RealClass());
        proxyClass.print();
    }
}
/**
 * 代理类
 */
class ProxyClass{
    private RealClass realClass;
    public ProxyClass(RealClass realClass) {
        this.realClass=realClass;
    }

    public void print(){
        System.out.println("开始代理");
        realClass.print();
        System.out.println("结束代理");

    }
}
/***
 * 被代理类
 */
class RealClass{
    public void print(){
        System.out.println("我是被代理者-真的类");
    }
}
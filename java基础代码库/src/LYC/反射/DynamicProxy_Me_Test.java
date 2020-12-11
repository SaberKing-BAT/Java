package LYC.反射;

import LYC.多线程.MemoryTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 动态代理：代理对象是不确定的；
 * 这个是非jdk提供的动态代理，是自我实现的一级代理，而jdk动态代理是个二级代理模式。
 * 一级代理模式中的增强方法是写死的。而二级代理是可以定制增强的方法的即所谓的代理工厂。
 *
 */
public class DynamicProxy_Me_Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        DRealClass dRealClass=new DRealClass();
        DProxyClass dProxyClass=new DProxyClass();
        dProxyClass.proxy(dRealClass,"print","123");
        dProxyClass.proxyMethod();
       //======================================================
        RealClass realClass=new RealClass();
        DProxyClass dProxyClass1=new DProxyClass();
        dProxyClass1.proxy(realClass,"print");
        dProxyClass1.proxyMethod();
    }
}
class ProxyFactory{

}
/**
 * 代理类
 */
class  DProxyClass{
    private Object realObject;
    private Method method;
    private Object[] args;

    public void proxy(Object obj,String methodName,Object... args) throws IllegalAccessException, InstantiationException {
        realObject=obj;
        Class c=realObject.getClass();
        c.newInstance();
        this.args=args;
        Method[] methods=c.getDeclaredMethods();
        for (Method m:methods
             ) {
            if (m.getName().equals(methodName));
            method=m;
        }
    }
    public void proxyMethod() throws InvocationTargetException, IllegalAccessException {
        System.out.println("开始代理");
        method.invoke(realObject,args);
        System.out.println("结束代理");
    }
}
/***
 * 被代理类
 */
class DRealClass{
    public void print(String str){
        System.out.println("我是被代理者-真的类："+str);
    }
}
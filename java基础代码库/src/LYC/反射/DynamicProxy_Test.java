package LYC.反射;

import LYC.多线程.MemoryTest;

import java.lang.reflect.Method;

public class DynamicProxy_Test {

}
/**
 * 代理类
 */
class  DProxyClass <T>{
    private T realClass;
    public DProxyClass(T realClass) {
        this.realClass=realClass;
    }

    public void print(){
        System.out.println("开始代理");
        Method method=
        realClass.print();
        System.out.println("结束代理");

    }
}
/***
 * 被代理类
 */
class DRealClass{
    public void print(){
        System.out.println("我是被代理者-真的类");
    }
}
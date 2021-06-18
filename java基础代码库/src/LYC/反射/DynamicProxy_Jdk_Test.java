package LYC.反射;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 第一步 编写被代理类接口
 * 第二步 编写被代理类
 * 第三步 编写代理模板实现InvocationHandler接口重写invoke代理方法；
 * 第四步 调用Proxy工具栏生成代理类
 */

interface Subject{
    public void printMassage(String str);
}
class SubjectImpl implements  Subject{
    @Override
    public void printMassage(String str) {
        System.out.println("我是被代理类,打印："+str);
    }
}

class MyProxyModel implements InvocationHandler{
    private Object subject;
    public MyProxyModel(Object subject) {
        this.subject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        System.out.println("增强开始");
        Object returnValue=method.invoke(subject,args);
        System.out.println("增强结束");
        return returnValue;
    }
    public  Object getProxy(){
        return  Proxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),this);
    }
}

public class DynamicProxy_Jdk_Test {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject subject=new SubjectImpl();
        //Subject myProxy= (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),Subject.class.getInterfaces(),new MyProxyModel(subject));//(MyProxyModel) Proxy.newProxyInstance(SubjectImpl.class.getClassLoader(),SubjectImpl.class.getInterfaces(),new MyProxyModel());
        Subject myProxy= (Subject)new MyProxyModel(subject).getProxy();
        myProxy.printMassage("hahah");
        System.out.println(Subject.class.getClassLoader());
        System.out.println(SubjectImpl.class.getClassLoader());
        System.out.println(Subject.class.getInterfaces());
        System.out.println(SubjectImpl.class.getInterfaces());
    }
}

package LYC.多线程.锁;

class Resource{
    private int count;
    private static int scount;
    private static Object object=new Object();

    public void setObject(Object object) {
        this.object = object;
    }
    //类代码块不可以
/*    synchronized {
        System.out.println();
    }*/

    //1、静态方法上
    synchronized static void sfun1(){
        System.out.println("静态方法上");
    }
    //2、非静态方法上
    synchronized void fun1(){
        System.out.println("非静态方法上");
    }

    //3.1、方法内部代码块
    void fun2(){
        synchronized(object){
            System.out.println("方法内部代码块");
        }
    }
    //3.2静态方法内部代码块
    static void sfun2(){
        synchronized (SynchronizedLearn_0.class){
            System.out.println("静态方法内部代码块");
        }
    }


}
public class SynchronizedLearn_0 {
    private Resource resource=new Resource();

    void testfun1(){
        for (int i=0;i<3;i++){
            new Thread(()->{
                resource.fun1();
                System.out.println(Thread.currentThread().getId());
            }).start();
        }
    }
    void testsfun1(){
        for (int i=0;i<3;i++){
            new Thread(()->{
                resource.sfun1();
                System.out.println(Thread.currentThread().getId());
            }).start();
        }
    }
    void testsfun2(){
        for (int i=0;i<3;i++){
            new Thread(()->{
                resource.sfun2();
                System.out.println(Thread.currentThread().getId());
            }).start();
        }
    }
    //
    void testfun2(){
        for (int i=0;i<3;i++){
            new Thread(()->{
                resource.fun2();
                System.out.println(Thread.currentThread().getId());
            }).start();
        }
    }
    public static void main(String[] args) {
        SynchronizedLearn_0 synchronizedLearn0=new SynchronizedLearn_0();
        synchronizedLearn0.testfun2();

    }


}

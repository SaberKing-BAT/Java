package LYC.多线程;

import java.util.concurrent.TimeUnit;

/**
 * springMVC是单例的（一个实例对象），但是方法可以被多个请求线程调用，不阻塞。
 *  1、每个线程调用方法都会创建 自己的虚拟机栈执行方法代码，线程似有，所以不会相互影响。
 *  2、方法种的局部变量是每个线程私有的，类中的实例变量，和静态变量是线程共享的。
 *  3、这就是springmvc controller 单例对象但是，多线程调用方法安全的原因。
 * */
public class SpringMVCControllerTest {
    private int flagCount=0;

    void testController(int i){
        flagCount++;
        System.out.println("请求"+i+":调用controller方法！"+"\nflagCount="+flagCount);
    }
    synchronized void  test(){

    }
    public static void main(String[] args) {
        SpringMVCControllerTest controller=new SpringMVCControllerTest();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                controller.testController(1);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }).start();
        new Thread(()->{
            controller.testController(2);
        }).start();
    }

}

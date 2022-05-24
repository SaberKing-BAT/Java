package LYC.多线程.锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptTest_0 {
    /**
     * TODO：测试线程的 响应中断。
     * 不可响应中断（线程卡在锁外面）:是指一个线程在获取同步资源的时候 没获取到在阻塞状态（ BLOCKED 同步阻塞）中的线程  无法响应退出。
     * 线程阻塞分三种：wait等待阻塞，同步阻塞，其他阻塞（sleep，join，io）
     * 1、synchronized  在同步阻塞中是无法被 interrupt的，因为此时是重锁，底层代码写的，无法响应。
     * 2、lock  lock.lock() 也是同步阻塞不可中断的。
     *          lock.tryLock() 是可中断的。超时不获得锁，不会卡在代码块外面。
     */

    int count = 10;
    Lock lock =new ReentrantLock();
    Condition c1=lock.newCondition();
    Condition c2=lock.newCondition();

    synchronized void resourceA() {
        System.out.println("resource 被" + Thread.currentThread().getName() + "抢占中");
        try {
            TimeUnit.SECONDS.sleep(count);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
    void resourceB(){
        try {
            lock.lock();
            System.out.println();
            System.out.println("resource 被" + Thread.currentThread().getName() + "抢占中");
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void lockTryLock()  {
        boolean b=false;
        try {
            b = lock.tryLock(3, TimeUnit.SECONDS);
            if (b) {
                System.out.println("resource 被" + Thread.currentThread().getName() + "抢占中");
                TimeUnit.SECONDS.sleep(count);
                lock.unlock();
            } else {
                System.out.println(Thread.currentThread().getName() + " :3秒没获得锁，自动结束");
            }
        }catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }finally {
            if (b)
                lock.unlock();
        }
    }

    void interruptTest() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
//            resourceA();
//            resourceB();
            lockTryLock();
        }, "线程A");

        Thread thread2 = new Thread(() -> {
//            resourceA();
//            resourceB();
            lockTryLock();
        }, "线程B");

        thread1.start();
        Thread.sleep(2000);
        thread2.start();
        System.out.println("线程A： " + thread1.getState());
//        thread1.interrupt();
        Thread.sleep(2000);         //这里睡眠2秒很重要，确保t2 线程已经阻塞。
        System.out.println("线程B： " + thread2.getState());
        thread2.interrupt();
        System.out.println("线程B： " + thread2.getState());
    }



    public static void main(String[] args) throws InterruptedException {
        InterruptTest_0 test = new InterruptTest_0();
        test.interruptTest();
    }
}

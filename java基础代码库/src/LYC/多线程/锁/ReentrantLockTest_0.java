package LYC.多线程.锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLockTest_0 {
    class Resouce implements Runnable{
        Lock lock = new ReentrantLock();
        void doSamething(){
            try {
                System.out.println(Thread.currentThread().getState());
                lock.lock();
                System.out.println(Thread.currentThread().getName()+": 把资源抢占中。。");
                Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+": 把资源抢占中。。");
                Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
    void  test() throws InterruptedException {
        Resouce r=new Resouce();
        Thread t1=new Thread(r,"t1");
        Thread t2=new Thread(r,"t2");

       /* Thread t2=new Thread(()->{
            r.doSamething();
        },"t2");
        */
        t1.start();
        Thread.sleep(2000);
        t2.start();
        System.out.println("t1:"+t1.getState());
        Thread.sleep(2000);         //这里睡眠2秒很重要，确保t2 线程已经阻塞。
        System.out.println("t2: "+t2.getState());
    }
    public static void main(String[] args) throws InterruptedException {
        new ReentrantLockTest_0().test();
    }

}

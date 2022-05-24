package LYC.lang.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 *
 */
public class ReferenceTest {
    /* 1、强引用
     *  就是平时的引用
     */
    void referenceFunction() {
        ReferenceTest referenceTest = new ReferenceTest(); //str 就是 对象的强引用
    }

    /* 2、软引用
     *  特点：内存不足才回收
     *  实验环境：
     *   1)、设置jvm参数  -Xmx=5m 让内存不足
     *   2)、创建大对象,用try cache 捕获oom
     *   3)、检验 weakReference null？
     */
    void softReferenceFunction() {
        String str = new String("对象");
        SoftReference<String> softReference = new SoftReference<>(str);
        try {
            str = null;  //释放强引用，只留软引用
            byte[] b = new byte[10 * 1024 * 1024];
        } catch (Exception e) {
            System.out.println("OOM内存不足");
        } finally {
            System.out.println("软引用对象：" + softReference.get());
        }
    }

    /* 3、弱引用
     * 特点：gc就回收
     */
    void weakReferenceFunction() throws InterruptedException {
        String str = new String("对象");
        WeakReference<String> weakReference = new WeakReference(str);
        str = null;  //释放强引用
        System.gc();        //gc方法虽然执行但不一定触发gc
        Thread.sleep(500);
        System.out.println("弱引用：" + weakReference.get());
    }

    /* 4、虚引用
     *  特点：就是没有get方法总是null，不能单独用，需要配合ReferenceQueue引用队列
     *  用途： 跟踪对象
     *  原理: 对象被GC后虚引用进入  引用队列,队列poll方法消费
     */
    void phantomReferenceFunction() throws InterruptedException {
        String str = new String("对象");
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference<String> phantomReference = new PhantomReference<>(str, referenceQueue);
        System.out.println("gc前虚引用：" + phantomReference.get());
        str = null;
        System.gc();        // 让str引用null 回收 "对象"
        Thread.sleep(500); //保证gc收集完毕
        System.out.println("gc后虚引用：" + phantomReference.get());
        System.out.println("虚引用-队列：" + referenceQueue.poll());
    }

    /*
     *   5.引用队列
     *   搭配,软\弱\虚使用
     *   软\弱\虚引用被GC回收前会被放入引用队列,可以利用这种消息通知机制,其他程序可以在检测到队列消息时,在对象
     *      被回收前采取必要的行动.
     */
    void referenceQueue() {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        SoftReference<String> softReference = new SoftReference<>(new String("软"), referenceQueue);
        WeakReference<String> weakReference = new WeakReference<>(new String("弱"), referenceQueue);
        PhantomReference<String> phantomReference = new PhantomReference<>(new String("虚"), referenceQueue);
        System.out.println("gc前软引用：" + softReference.get());
        System.out.println("gc前弱引用：" + weakReference.get());
        System.out.println("gc前虚引用：" + phantomReference.get());
        System.gc();
        System.out.println("gc后软引用：" + softReference.get()); //内存够,不会被回收
        System.out.println("gc后弱引用：" + weakReference.get());
        System.out.println("gc后虚引用：" + phantomReference.get());
        System.out.println("队列-1：" + referenceQueue.poll());
        System.out.println("队列-2：" + referenceQueue.poll());
        System.out.println("队列-3：" + referenceQueue.poll());

    }


    public static void main(String[] args) throws InterruptedException {
        ReferenceTest referenceTest = new ReferenceTest();
//        referenceTest.softReferenceFunction();  //软
//        referenceTest.weakReferenceFunction();  //弱
//        referenceTest.phantomReferenceFunction();  //虚
        referenceTest.referenceQueue();  //队列
    }
}

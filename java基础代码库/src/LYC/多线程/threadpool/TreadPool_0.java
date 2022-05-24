package LYC.多线程.threadpool;

import java.util.concurrent.*;

/**
 * 七大参数：
 *  1、corePoolSize  核心线程数       cpu核心线程 1-2倍
 *  2、maximumPoolSize 最大线程数
 *  3、                存活时间 （超过核心线程数量的线程最大空闲时间）
 *  4、                时间单位  时，分，秒
 *  5、                阻塞队列（等待的线程个数）
 *  6、                线程工厂
 *  7、                拒绝策略 （阻塞队列也满了，开始使用拒绝策略）
 */
public class TreadPool_0 {
    void test() throws ExecutionException, InterruptedException {


        ThreadPoolExecutor executor=new ThreadPoolExecutor(
                16,
                200,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8),   //最大队列不可太满（默认值是int最大值），根据压力测试得到，还要考虑为服务器其他应用留资源
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        Future future=executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        });
        future.get();
    }
}

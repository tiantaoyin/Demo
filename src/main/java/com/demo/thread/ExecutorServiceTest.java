package com.demo.thread;

import com.demo.common.Constant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService线程池
 * Created by ankang on 2017-03-25.
 */
public class ExecutorServiceTest {
    public static void main(String[] args) {
        /**
         Executors类，提供了一系列工厂方法用于创先线程池，返回的线程池都实现了ExecutorService接口。
         public static ExecutorService newFixedThreadPool(int nThreads) 
         创建固定数目线程的线程池。
         public static ExecutorService newCachedThreadPool() 
         创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
         public static ExecutorService newSingleThreadExecutor() 
         创建一个单线程化的Executor。
         public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) 
         创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
         ExecutoreService提供了submit()方法，传递一个Callable，或Runnable，返回Future。如果Executor后台线程池还没有完成Callable的计算，这调用返回Future对象的get()方法，会阻塞直到计算完成。
         */
        ExecutorService executorService = Executors.newFixedThreadPool(Constant.THREAD_POOL_SIZE);
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("ExecutorServiceTest");
            }
        });
        executorService.shutdown();
    }
}

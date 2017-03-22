package com.demo.thread;

import com.demo.common.Constant;
import com.demo.domain.MyCallable;
import com.demo.util.PropertiesUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 实现多线程方式:使用ExecutorService、Callable、Future实现有返回结果的多线程
 * ExecutorService、Callable、Future这个对象实际上都是属于Executor框架中的功能类。
 * 想要详细了解Executor框架的可以访问http://www.javaeye.com/topic/366591 ，这里面对该框架做了很详细的解释。
 * 可返回值的任务必须实现Callable接口，类似的，无返回值的任务必须Runnable接口。
 * 执行Callable任务后，可以获取一个Future的对象，在该对象上调用get就可以获取到Callable任务返回的Object了，
 * 再结合线程池接口ExecutorService就可以实现传说中有返回结果的多线程了。
 * Created by ankang on 2017-01-31.
 */
public class ImplementsCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("--------程序开始运行---------");
        Date begin = new Date();

        /**
         * 创建固定数目线程的线程池
         * public static ExecutorService newFixedThreadPool(int nThreads)
         * public static ExecutorService newCachedThreadPool() 
         * 创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。
         * 如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
         * public static ExecutorService newSingleThreadExecutor() 创建一个单线程化的Executor。
         * public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) 
         * 创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
         */
        ExecutorService pool = Executors.newFixedThreadPool(Constant.TASKSIZE);

        //创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < Constant.TASKSIZE; i++) {
            Callable callable = new MyCallable(i + "");

            /**
             * 执行任务并获取Future对象
             * ExecutoreService提供了submit()方法，传递一个Callable，或Runnable，返回Future。
             * 如果Executor后台线程池还没有完成Callable的计算，这调用返回Future对象的get()方法，会阻塞直到计算完成。
             */
            Future future = pool.submit(callable);
            list.add(future);
        }

        //关闭线程池 
        pool.shutdown();

        //获取所有并发任务的运行结果
        for (Future future : list) {
            //从Future对象上获取任务的返回值，并输出到控制台 
            System.out.println(">>>" + future.get().toString());
        }

        Date end = new Date();
        System.out.println("----程序结束运行----，程序运行时间【" + (end.getTime() - begin.getTime()) + "毫秒】");
    }
}

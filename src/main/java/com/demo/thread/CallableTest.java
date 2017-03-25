package com.demo.thread;

import com.demo.common.Constant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 使用ExecutorService、Callable、Future实现有返回结果的多线程
 * ExecutorService、Callable、Future这个对象实际上都是属于Executor框架中的功能类。
 * 返回值的任务必须实现Callable接口，类似的，无返回值的任务必须Runnable接口。
 * 执行Callable任务后，可以获取一个Future的对象，在该对象上调用get就可以
 * 获取到Callable任务返回的Object了，再结合线程池接口ExecutorService就可以
 * 实现传说中有返回结果的多线程了。
 * Created by ankang on 2017-03-25.
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("----程序开始运行----");
        Date date1 = new Date();

        // 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(Constant.TASK_SIZE);
        // 创建多个有返回值的任务 
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < Constant.TASK_SIZE; i++) {
            Callable callable = new MyCallable(i + "");
            // 执行任务并获取Future对象
            Future future = executorService.submit(callable);

            list.add(future);
        }

        // 关闭线程池 
        executorService.shutdown();
        // 获取所有并发任务的运行结果 
        for (Future future : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            //调用get就可以获取到Callable任务返回的Object
            System.out.println(">>>" + future.get().toString());
        }

        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【"
                + (date2.getTime() - date1.getTime()) + "毫秒】");
    }
}

class MyCallable implements Callable<Object> {
    private String taskNum;

    MyCallable() {
    }

    MyCallable(String taskNum) {
        this.taskNum = taskNum;
    }

    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        Date beginTime = new Date();
        Thread.sleep(1000);
        Date endTime = new Date();
        long time = endTime.getTime() - beginTime.getTime();
        System.out.println(">>>" + taskNum + "任务终止");
        return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }
}
package com.demo.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by ankang on 2017-02-04.
 */
@Slf4j
public class CallableAndFuture {
    /**
     * Callable接口类似于Runnable，但是Runnable不会返回结果，并且无法抛出返回结果的异常，而Callable功能更强大一些，
     * 被线程执行后，可以返回值，这个返回值可以被Future拿到，也就是说，Future可以拿到异步执行任务的返回值
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };
        /**
         * FutureTask实现了两个接口，Runnable和Future，所以它既可以作为Runnable被线程执行，又可以作为Future得到Callable的返回值，
         * 假设有一个很耗时的返回值需要计算，并且这个返回值不是立刻需要的话，那么就可以使用这个组合，用另一个线程去计算返回值，
         * 而当前线程在使用这个返回值之前可以做其它的操作，等到需要这个返回值时，再通过Future得到
         */
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        task(future.get());
    }

    /**
     * 通过ExecutorService的submit方法执行Callable，并返回Future
     * ExecutorService继承自Executor，它的目的是为我们管理Thread对象，从而简化并发编程，Executor使我们无需显示的去管理线程的
     * 生命周期，是JDK 5之后启动任务的首选方式。
     * 执行多个带返回值的任务，并取得多个返回值
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        /**
         * 这里也可以不使用CompletionService，可以先创建一个装Future类型的集合，
         * 用Executor提交的任务返回值添加到集合中，最后遍历集合取出数据
         * 两个方法最大的差别在于遍历 Future 的顺序，相对来说， CompletionService 的性能更高。
         * 考虑如下场景：多线程下载，结果用Future返回。第一个文件特别大，后面的文件很小。
         * 用CompletionService，能很快知道已经下载完文件的结果(不是第一个)；
         * 而用Future类型的集合，必须等第一个文件下载结束后，才会获得其他文件的下载结果。
         * 注:提交到CompletionService中的Future是按照完成的顺序排列的，这种做法中Future是按照添加的顺序排列的
         */
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
        for (int i = 1; i < 5; i++) {
            final int taskID = i;
            cs.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    return taskID;
                }
            });
        }
        // 可能做一些事情
        for (int i = 1; i < 5; i++) {
            try {
                /**
                 * CompletionService.take 会获取并清除已经完成Task的结果，如果当前没有已经完成Task时，会阻塞。
                 */
                System.out.println(cs.take().get());
            } catch (InterruptedException e) {
                log.error("An Error happened when execute thread, The Error Message is ", e);
            } catch (ExecutionException e) {
                log.error("An Error happened when execute thread, The Error Message is ", e);
            }
        }
        threadPool.shutdown();
    }


    private void task(Integer x) {
        try {
            Thread.sleep(5000);// 可能做一些事情
            System.out.println(x);
        } catch (InterruptedException e) {
            log.error("An Error happened when execute thread, The Error Message is ", e);
        }
    }
}

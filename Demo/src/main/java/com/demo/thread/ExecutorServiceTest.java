package com.demo.thread;

import com.demo.common.Constant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池ExecutorService
 * Created by ankang on 2017-01-31.
 */
public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Constant.TASKSIZE);
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });
        executorService.shutdown();
    }
}

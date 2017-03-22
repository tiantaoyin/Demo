package com.demo.lock;

import com.demo.util.ExecutorUtils;

/**
 * Created by ankang on 2017-01-11.
 */
public class SynchronizedDemo {
    private int count = 0;

    public int sum() {
        //synchronized保证在同一时间只有一个线程可以执行count++
        synchronized (this) {
            return ++count;
        }
    }


    public static void main(String[] args) {
        ExecutorUtils.getExecutorService().execute(new Runnable() {
            public void run() {
                int sum = new SynchronizedDemo().sum();
                System.out.println(sum);
            }
        });
        ExecutorUtils.close();
    }
}

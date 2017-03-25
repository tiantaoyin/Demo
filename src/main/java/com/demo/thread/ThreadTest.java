package com.demo.thread;

/**
 * 继承Thread类+实现Runnable接口
 * Created by ankang on 2017-03-25.
 */
public class ThreadTest {
    public static void main(String[] args) {
        /**
         * Thread本质上也是实现了Runnable接口的一个实例，它代表一个线程的实例，
         * 并且，启动线程的唯一方法就是通过Thread类的start()实例方法。
         * start()方法是一个native方法，它将启动一个新线程，并执行run()方法。
         * */
        Thread1 thread1 = new Thread1();
        thread1.start();

        Thread2 thread2 = new Thread2();
        //为了启动Thread2，需要首先实例化一个Thread，并传入自己的Thread2实例
        Thread thread=new Thread(thread2);
        thread.start();
    }
}
class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread1.run()");
    }
}
class Thread2 implements Runnable{
    public void run() {
        System.out.println("Thread2.run()");
    }
}
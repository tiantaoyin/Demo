package com.demo.thread;

/**
 * 实现多线程方式:继承Thread类
 * 继承Thread类的方法尽管被我列为一种多线程实现方式，但Thread本质上也是实现了Runnable接口的一个实例，
 * 它代表一个线程的实例，并且，启动线程的唯一方法就是通过Thread类的start()实例方法。
 * start()方法是一个native方法，它将启动一个新线程，并执行run()方法。这种方式实现多线程很简单，
 * 通过自己的类直接extend Thread，并复写run()方法，就可以启动新线程并执行自己定义的run()方法。
 * Created by ankang on 2017-01-31.
 */
public class  ExtendsThreadTest extends Thread {
    @Override
    public void run() {
        System.out.println(" ExtendsThreadTest.run()");
    }

    public static void main(String[] args) {
        ExtendsThreadTest  extendsThreadTest = new  ExtendsThreadTest();
        extendsThreadTest.start();
    }
}

package com.demo.thread;

/**
 * 实现多线程方式:实现Runnable接口
 * 注:为了启动MyThread，需要首先实例化一个Thread，并传入自己的MyThread实例
 * Created by ankang on 2017-01-31.
 */
public class ImplementsRunnableTest implements Runnable {
    public void run() {
        System.out.println("ImplementsRunnableTest.run()");
    }

    public static void main(String[] args) {
        ImplementsRunnableTest implementsRunnableTest = new ImplementsRunnableTest();
        //为了启动MyThread，需要首先实例化一个Thread，并传入自己的MyThread实例
        /**
         * 事实上，当传入一个Runnable target参数给Thread后，Thread的run()方法就会调用target.run()，参考JDK源代码：
         * public void run() {  
         * 　　if (target != null) {  
         * 　　 target.run();  
         * 　　}  
         * }  
         */
        Thread thread = new Thread(implementsRunnableTest);
        thread.start();
    }
}

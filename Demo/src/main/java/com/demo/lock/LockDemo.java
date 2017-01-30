package com.demo.lock;

import com.demo.util.ExecutorUtils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ankang on 2017-01-11.
 */
public class LockDemo {
    private int count = 0;
    /**
     * ReentrantLock(重入锁)是一个可重入的互斥锁，调用lock()的线程可以获取锁,调用unlock()的线程可以释放锁。
     */
    private ReentrantLock lock = new ReentrantLock();

    /**
     * isHeldByCurrentThread() 和 getHoldCount()方法来检查当前线程是否拥有该锁
     *  boolean	isHeldByCurrentThread() 查询当前线程是否保持此锁。
     *  int	getHoldCount()  查询当前线程保持此锁的次数。
     *  boolean	isLocked() 查询此锁是否由任意线程保持。
     *  protected  Thread	getOwner() 返回目前拥有此锁的线程，如果此锁不被任何线程拥有，则返回 null。
     *  建议总是 立即实践，使用 lock 块来调用 try，在之前/之后的构造中，最典型的代码如下：

     class X {
     private final ReentrantLock lock = new ReentrantLock();
     // ...

     public void m() {
         lock.lock();  // block until condition holds
         try {
            // ... method body
         } finally {
            lock.unlock()
         }
        }
     }
     * @return
     */
    public int sum() {
        assert !lock.isHeldByCurrentThread();
        lock.lock();
        try {
            return ++count;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorUtils.getExecutorService().submit(new Runnable() {
            public void run() {
                int sum = new LockDemo().sum();
                System.out.println(sum);
            }
        });
        ExecutorUtils.close();
    }
}

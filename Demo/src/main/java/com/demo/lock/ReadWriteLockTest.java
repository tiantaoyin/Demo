package com.demo.lock;

import com.demo.common.Constant;
import com.demo.domain.MyAccount;
import com.demo.domain.UserAccount;
import com.demo.util.ExecutorUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ankang on 2017-01-11.
 */
public class ReadWriteLockTest {
    /**
     * 读写锁在同一时刻可以允许多个读线程访问，但是在写线程访问时，所有的读线程和其他写线程均被阻塞。
     * 读写锁维护了一对锁，一个读锁和一个写锁，通过分离读锁和写锁，在读的地方使用读锁，在写的地方使用写锁，使得并发性相比一般的排他锁有了很大提升。
     * 如果没有写锁的情况下，读是无阻塞的,在一定程度上提高了程序的执行效率。
     * ReentrantReadWriteLock 和 ReentrantLock 不是继承关系，但都是基于 AbstractQueuedSynchronizer 来实现。
     * 注意：
     * 在同一线程中，持有读锁后，不能直接调用写锁的lock方法 ，否则会造成死锁。
     * 读写锁的优势只有在多读少写、代码段运行时间长这两个条件下才会效率达到最大化；
     * 任何公共数据的修改都必须在锁里面完成；
     * 读锁和写锁一定要分开使用，否则达不到效果。
     */
    public static void main(String[] args) {
        //创建并发访问的账户  
        MyAccount myAccount = new MyAccount(Constant.ACCOUNTNO, 10000);
        /**
         * 创建一个锁对象 
         * ReentrantReadWriteLock() 使用默认（非公平）的排序属性创建一个新的 ReentrantReadWriteLock。
         * ReentrantReadWriteLock(boolean fair) 使用给定的公平策略创建一个新的 ReentrantReadWriteLock。
         */
        ReadWriteLock lock = new ReentrantReadWriteLock(false);
        //创建一些并发访问用户，一个信用卡，存的存，取的取
        UserAccount u1 = new UserAccount("张三", myAccount, -4000, lock, false);
        UserAccount u2 = new UserAccount("张三媳妇", myAccount, 2000, lock, false);
        UserAccount u3 = new UserAccount("张三儿子", myAccount, -1000, lock, false);
        UserAccount u4 = new UserAccount("张三", myAccount, +3000, lock, false);
        UserAccount u5 = new UserAccount("张三媳妇", myAccount, 0, lock, true);
        //在线程池中执行各个用户的操作
        ExecutorService executorService = ExecutorUtils.getExecutorService();
        executorService.execute(u1);
        executorService.execute(u2);
        executorService.execute(u3);
        executorService.execute(u4);
        executorService.execute(u5);
        //关闭线程池
        ExecutorUtils.close();
    }
}

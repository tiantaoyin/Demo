package com.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by ankang on 2017-01-11.
 */
@Data
@AllArgsConstructor
public class UserAccount implements Runnable {
    private String name;    //用户名  
    private MyAccount myAccount;    //所要操作的账户  
    private int iocash; //操作的金额，当然有正负之分了  
    private ReadWriteLock myLock;   //执行操作所需的锁对象  
    private boolean ischeck;    //是否查询  

    public void run() {
        if (ischeck) {
            //获取读锁  
            myLock.readLock().lock();
            System.out.println("读: " + name + "正在查询" + myAccount + "账号,当前金额为" + myAccount.getCash());
            //释放读锁
            myLock.readLock().unlock();
        } else {
            //获取写锁
            myLock.writeLock().lock();
            //执行操作
            System.out.println("写: " + name + "正在操作" + myAccount + "账号中,当前金额为" + myAccount.getCash());
            myAccount.setCash(myAccount.getCash() + iocash);
            System.out.println("写: " + name + "正在操作" + myAccount + "账号成功,当前金额为" + myAccount.getCash());
            //释放写锁
            myLock.writeLock().unlock();
        }
    }
}

package com.pcm.waitnotify;

import com.pcm.common.Constant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * 仓库类Storage实现缓冲区
 * Created by ankang on 2017-02-07.
 */
@Slf4j
@Data
public class Storage {
    // 仓库最大存储量
    private final int MAX_SIZE = Constant.STORAGE_MAX_SIZE;

    // 仓库存储的载体
    private LinkedList<Object> list = new LinkedList<Object>();

    // 生产num个产品  
    public void produce(int num) {
        // 同步代码段 
        synchronized (list) {
            // 如果仓库剩余容量不足
            while (list.size() + num > MAX_SIZE) {
                System.out.println("【要生产的产品数量】:" + num + "  【库存量】:" + list.size() + "   暂时不能执行生产任务!");
                // 由于条件不满足，生产阻塞
                try {
                    //消费线程等待
                    log.info("the consume thread wait ...");
                    list.wait();
                } catch (InterruptedException e) {
                    log.error("the thread was interrupted, the error message is {}", e);
                }
            }

            // 生产条件满足情况下，生产num个产品
            for (int i = 1; i <= num; i++) {
                list.add(new Object());
                System.out.println("【已经生产产品数】:" + num + "  【现仓储量为】:" + list.size());
                //唤醒所有线程
                log.info("notify all thread  ...");
                list.notifyAll();
            }
        }
    }

    // 消费num个产品
    public void consume(int num) {
        // 同步代码段 
        synchronized (list) {
            // 如果仓库存储量不足
            while (list.size() < num) {
                System.out.println("【要消费的产品数量】:" + num + "  【库存量】:" + list.size() + "   暂时不能执行消费任务!");
                // 由于条件不满足，消费阻塞
                try {
                    //消费线程等待
                    log.info("the consume thread wait ...");
                    list.wait();
                } catch (InterruptedException e) {
                    log.error("the thread was interrupted, the error message is {}", e);
                }
            }

            // 消费条件满足情况下，消费num个产品
            for (int i = 1; i <= num; i++) {
                list.remove();
            }
            System.out.println("【已经消费产品数】:" + num + "  【现仓储量为】:" + list.size());
            //唤醒所有线程
            log.info("notify all thread  ...");
            list.notifyAll();
        }
    }
}

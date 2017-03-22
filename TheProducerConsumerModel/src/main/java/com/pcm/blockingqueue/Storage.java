package com.pcm.blockingqueue;

import com.pcm.common.Constant;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ankang on 2017-03-22.
 */
@Slf4j
@Data
public class Storage {
    // 仓库最大存储量
    private final int MAX_SIZE = Constant.STORAGE_MAX_SIZE;

    //仓库存储载体
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>(Constant.STORAGE_MAX_SIZE);

    //生产num个产品
    public void produce(int num) {
        //如果仓库剩余容量为0
        if (list.size() == MAX_SIZE) {
            System.out.println("【库存量】:" + MAX_SIZE + "/t暂时不能执行生产任务!");
        }

        //生产条件满足情况下,生产num个产品
        for (int i = 1; i <= num; i++) {
            //放入产品,自动阻塞
            try {
                list.put(new Object());
            } catch (InterruptedException e) {
                log.error("the thread was interrupted, the error message is {}", e);
            }

            System.out.println("【现仓储量为】:" + list.size());
        }
    }

    // 消费num个产品
    public void consume(int num) {
        // 如果仓库存储量不足
        if (list.size() == 0) {
            System.out.println("【库存量】:0  暂时不能执行生产任务!");
        }

        // 消费条件满足情况下，消费num个产品
        for (int i = 1; i <= num; i++) {
            try {
                list.take();
            } catch (InterruptedException e) {
                log.error("the thread was interrupted, the error message is {}", e);
            }

            System.out.println("【现仓储量为】:" + list.size());
        }
    }
}

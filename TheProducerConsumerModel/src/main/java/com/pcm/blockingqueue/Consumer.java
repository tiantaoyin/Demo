package com.pcm.blockingqueue;

import lombok.Data;

/**
 * 消费者类Consumer继承线程类Thread 
 * Created by ankang on 2017-02-07.
 */
@Data
public class Consumer extends Thread {
    // 每次消费的产品数量
    private int num;

    // 所在放置的仓库
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    // 线程run函数
    @Override
    public void run() {
        consum(num);
    }

    // 调用仓库Storage的生产函数  
    public void consum(int num) {
        storage.consume(num);
    }
}

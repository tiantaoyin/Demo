package com.pcm.blockingqueue;

import lombok.Data;

/**
 * 生产者类Producer继承线程类Thread
 * Created by ankang on 2017-02-07.
 */
@Data
public class Producer extends Thread {
    // 每次生产的产品数量
    private int num;

    // 所在放置的仓库
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    // 线程run函数
    @Override
    public void run() {
        produce(num);
    }

    // 调用仓库Storage的生产函数
    public void produce(int num) {
        storage.produce(num);
    }
}

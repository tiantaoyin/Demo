package com.demo.service.proxy;

import com.demo.service.Subject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 代理类，实现了代理接口。 
 * Created by ankang on 2017-01-12.
 */
@Slf4j
public class ProxySubject implements Subject {
    /**
     * 代理类持有一个委托类的对象引用  
     */
    private Subject delegate;

    public ProxySubject(Subject delegate) {
        this.delegate = delegate;
    }
    public ProxySubject() {
    }
    /**
     * 额外功能
     * @param taskName
     */
    public void dealTask(String taskName) {
        log.info("invoke method ...");
        long beginTime = System.currentTimeMillis();
        delegate.dealTask(taskName);
        log.info("invoke method over");
        long endTime = System.currentTimeMillis();
        log.info("This Task cast " + (endTime - beginTime) + "Millis");
    }
}

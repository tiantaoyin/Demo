package com.demo.service.proxy;

import com.demo.service.Subject;
import com.demo.service.impl.RealSubject;
import lombok.extern.slf4j.Slf4j;

/**
 * 代理类，实现了代理接口。 
 * Created by ankang on 2017-01-12.
 */
@Slf4j
public class StaticProxySubject implements Subject {
    /**
     * 代理类持有一个委托类的对象引用  
     */
    private RealSubject delegate;

    public StaticProxySubject(RealSubject delegate) {
        this.delegate = delegate;
    }

    /**
     * 额外功能:添加日志
     *
     * @param taskName
     */
    public void dealTask(String taskName) {
        log.info("invoke method ...");
        System.out.println(delegate);
        delegate.dealTask(taskName);
        log.info("invoke method over");
    }
}

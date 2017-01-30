package com.demo.service.impl;

import com.demo.service.Subject;

/**
 * 真正执行任务的类，实现了代理接口。
 * Created by ankang on 2017-01-12.
 */
public class RealSubject implements Subject {
    /**
     * 执行给定名字的任务。
     *
     * @param taskName
     */
    public void dealTask(String taskName) {
        System.out.println("正在执行任务：" + taskName);
    }
}

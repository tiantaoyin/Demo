package com.demo.service;

/**
 * 代理接口。处理给定名字的任务。 
 * Created by ankang on 2017-01-29.
 */
public interface Subject {
    /**
     * 执行给定名字的任务
     * @param taskName
     */
    void dealTask(String taskName);}

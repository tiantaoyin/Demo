package com.demo.domain;

import lombok.Data;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by ankang on 2017-01-31.
 */
@Data
public class MyCallable implements Callable {
    private String taskNum;

    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        Date dateTmp1 = new Date();
        Thread.sleep(1000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>" + taskNum + "任务终止");
        return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }

    public MyCallable(String taskNum) {
        this.taskNum = taskNum;
    }
}

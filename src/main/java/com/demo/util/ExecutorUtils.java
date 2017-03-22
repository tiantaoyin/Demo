package com.demo.util;

import com.demo.common.Constant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorUtils {

    public static ExecutorService executorService = null;

    public static synchronized ExecutorService getExecutorService() {
        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(Constant.THREAD_POOL_SIZE);
        }
        return executorService;
    }

    public static void close(){
        if (executorService == null) {
            executorService = getExecutorService();
        }
        executorService.shutdown();
    }
}

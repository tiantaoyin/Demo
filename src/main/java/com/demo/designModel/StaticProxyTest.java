package com.demo.designModel;

import com.demo.service.proxy.StaticProxySubject;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by ankang on 2017-01-29.
 */
@Slf4j
public class StaticProxyTest {
    public static void main(String[] args) {
        try {
            log.info("getting object ...");
            StaticProxySubject proxySubject = (StaticProxySubject) FindClassUtils.findClassByPath("proxy");
            log.info("dealing task ...");
            long beginTime = System.currentTimeMillis();
            proxySubject.dealTask("DBQueryTask");
            log.info("dealing task over");
            System.out.println("任务耗时" + (System.currentTimeMillis() - beginTime));
        } catch (Exception e) {
            log.error("An Error happend when geting object, The Error Message is ", e);
        }
    }
}

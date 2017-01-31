package com.demo.designModel;

import com.demo.service.Subject;
import com.demo.service.impl.RealSubject;
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
            StaticProxySubject proxySubject = (StaticProxySubject) getInstance();
            log.info("dealing task ...");
            long beginTime = System.currentTimeMillis();
            proxySubject.dealTask("DBQueryTask");
            log.info("dealing task over");
            System.out.println("DBQueryTask cast " + (System.currentTimeMillis() - beginTime) + " Millis");
        } catch (Exception e) {
            log.error("An Error happened when getting object, The Error Message is ", e);
        }
    }

    public static Subject getInstance() {
        return new StaticProxySubject(new RealSubject());
    }
}

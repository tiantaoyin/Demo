package com.demo.designModel.FactoryModel;

import com.demo.service.Subject;
import com.demo.service.impl.RealSubject;
import com.demo.service.proxy.ProxySubject;

/**
 * Created by ankang on 2017-03-25.
 */
public class SubjectStaticFactory {
    public static Subject getInstance(){
        return new ProxySubject(new RealSubject());
    }
}

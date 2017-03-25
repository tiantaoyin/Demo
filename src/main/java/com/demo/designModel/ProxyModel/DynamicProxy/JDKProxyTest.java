package com.demo.designModel.ProxyModel.DynamicProxy;

import com.demo.service.Subject;
import com.demo.service.impl.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于接口的代理
 * Created by ankang on 2017-03-25.
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        final Subject subject = new RealSubject();

        /**
         * 调用JDK底层Proxy方法
         *  1 借用ClassLoader
         *  2 原始对象所实现的接口
         *  3 额外功能 InvocationHandler
         * */
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * method:原始方法
             * args:原始方法参数
             * 返回值:原始方法返回值
             * */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("--------------- JDKProxy ------------------");
                return method.invoke(subject, args);
            }
        };

        Subject s = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), subject.getClass().getInterfaces(), invocationHandler);

        s.dealTask("JDKProxyTest");
    }
}

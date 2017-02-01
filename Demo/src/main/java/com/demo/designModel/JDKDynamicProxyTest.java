package com.demo.designModel;

import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Spring动态代理:JDK动态代理
 * 注:InvocationHandler--->java.lang.reflect.InvocationHandler
 * Created by ankang on 2017-01-30.
 */
@Slf4j
public class JDKDynamicProxyTest {

    public static void main(String[] args) {
        final UserService userService = new UserServiceImpl();

        /**
         * 调用JDK底层Proxy方法
         *  1 借用ClassLoader
         *  2 原始对象所实现的接口
         *  3 额外功能 InvocationHandler
         */
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             *
             * @param proxy
             * @param method  原始方法
             * @param args   原始方法参数
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                log.info("=================JDKDynamicProxy===================");
                return method.invoke(userService, args);
            }
        };
        UserService us = (UserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(), userService.getClass().getInterfaces(), invocationHandler);
        us.query();
    }
}

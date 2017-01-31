package com.demo.designModel;

import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ankang on 2017-01-30.
 */
@Slf4j
public class DynamicProxyTest {

    private UserService userService = new UserServiceImpl();

    @Test
    public void JDKDynamicProxy() {
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

    @Test
    public void CglibDynamicProxy() {
        //核心类Enhancer   类加载器省略
        Enhancer enhancer = new Enhancer();

        //设置父类/接口   setSuperclass()
        enhancer.setSuperclass(userService.getClass());

        //创建额外功能
        InvocationHandler invocationHandler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                log.info("=================CglibDynamicProxy===================");
                return method.invoke(userService, args);
            }
        };

        //设置额外功能    setCallback()
        enhancer.setCallback(invocationHandler);

        //创建代理  create()
        UserService us = (UserService) enhancer.create();

        us.query();
    }
}

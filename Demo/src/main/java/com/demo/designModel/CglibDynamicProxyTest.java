package com.demo.designModel;

import com.demo.service.UserService;
import com.demo.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * Created by ankang on 2017-01-31.
 */
@Slf4j
public class CglibDynamicProxyTest {
    public static void main(String[] args) {
        final UserService userService = new UserServiceImpl();

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

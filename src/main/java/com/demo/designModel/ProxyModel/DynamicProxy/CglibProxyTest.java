package com.demo.designModel.ProxyModel.DynamicProxy;

import com.demo.service.impl.RealSubject;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * cglib动态字节码增加技术完成 （不基于接口，继承的方式）
 * 核心编程思路 cglib (类加载器（省略） +  父类 +  额外功能)
 * 注:这里的InvocationHandler是cglib.jar包(net.sf.cglib.proxy.InvocationHandler)的.
 * Created by ankang on 2017-03-25.
 */
public class CglibProxyTest {
    public static void main(final String[] args) {
        final RealSubject realSubject = new RealSubject();
        Enhancer enhancer = new Enhancer();

        //设置父类
        enhancer.setSuperclass(realSubject.getClass());

        //创建额外功能
        InvocationHandler invocationHandler = new InvocationHandler() {
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                System.out.println("----------------- CglibProxyTest -----------------");
                return method.invoke(realSubject, args);
            }
        };

        //设置额外功能
        enhancer.setCallback(invocationHandler);

        //创建代理
        RealSubject rs = (RealSubject) enhancer.create();
        rs.dealTask("CglibProxyTest");
    }
}

package com.demo.designModel.SingletonModel;

/**
 * 单例模式:只能创建一个对象
 * 1.构造方法私有化
 * 2.提供公开的getInstance()
 * Created by ankang on 2017-01-11.
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        System.out.println(singleton1);
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton2);
    }
}

/**
 * 懒汉模式:
 */
class Singleton1 {
    private Singleton1() {
    }

    private static Singleton1 instance;

    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}

/**
 * 饿汉模式:
 */
class Singleton2 {
    private Singleton2() {
    }

    private static Singleton2 instance = new Singleton2();

    public static Singleton2 getInstance() {
        return instance;
    }
}

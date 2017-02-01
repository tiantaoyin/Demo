package com.demo.other;

import com.demo.domain.Dog;

/**
 * 类加载顺序:
 * 父类静态属性--->父类静态代码块--->子类静态属性--->子类静态代码块--->父类实例属性--->父类动态代码块
 * --->父类构造方法--->子类实例属性--->子类动态代码块--->子类构造方法
 * Created by ankang on 2017-01-31.
 */
public class ClassLoaderRoundTest {

    public static void main(String[] args) {
        Dog dog = new Dog();
    }
}

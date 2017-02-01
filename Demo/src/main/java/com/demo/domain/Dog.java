package com.demo.domain;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by ankang on 2017-01-31.
 */
@Slf4j
public class Dog extends Anmial {
    private static String name = "tom";
    private String furColor;

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类动态代码块");
    }

    public Dog(String sex, String furColor) {
        super(sex);
        System.out.println("子类有参构造");
        this.furColor = furColor;
    }

    public Dog() {
        System.out.println("子类无参构造");
    }
}

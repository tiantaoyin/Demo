package com.demo.domain;

/**
 * Created by ankang on 2017-01-31.
 */
public class Anmial {
    private static int age = 1;
    private String sex;

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类动态代码块");
    }

    public Anmial(String sex) {
        System.out.println("父类有参构造");
        this.sex = sex;
    }

    public Anmial() {
        System.out.println("父类无参构造");
    }
}

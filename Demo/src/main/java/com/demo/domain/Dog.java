package com.demo.domain;

/**
 * Created by ankang on 2017-01-31.
 */
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

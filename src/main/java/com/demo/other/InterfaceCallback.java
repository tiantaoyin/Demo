package com.demo.other;

import java.util.Scanner;

/**
 * 接口回调---验证哥德巴赫猜想(任一大于2的偶数都可写成两个质数之和。)
 * Created by ankang on 2017-03-25.
 */
public class InterfaceCallback {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个大于2的偶数.");
        int n = scanner.nextInt();

        PrimeTest primeTest = new PrimeTest();
        /**
         * 把n拆分成i + (n-i)
         * 当i=2时,则n-i一定为偶数,一定不是质数,只有奇数才有可能是质数(2除外),所以i+=2
         */
        for (int i = 3; i < n / 2; i += 2) {
            if (primeTest.isPrime(n - i) && primeTest.isPrime(i)) {
                System.out.println(n + "=" + i + "+" + (n - i));
            }
        }
    }
}

interface Prime {
    boolean isPrime(int n);
}

class PrimeTest implements Prime {

    public boolean isPrime(int n) {
        /**
         * Math.sqrt(n) 求n的平方根
         * 判断是否是质数:for (int i = 2; i < Math.sqrt(n); i++) {...}
         */
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

package com.demo.other;

/**
 * 函数的递归调用---汉诺塔
 * Created by ankang on 2017-03-25.
 */
public class RecursionTest {
    public static void main(String[] args) {
        trans(5, "A", "B", "C");
    }

    private static void trans(int n, String from, String to, String temp) {
        if (n == 1) {
            System.out.println(from + "--->" + to);
        } else {
            //把n-1个盘子从from柱移动到temp柱,借助to柱
            trans(n - 1, from, temp, to);

            System.out.println(from + "--->" + to);

            //把n-1个盘子从temp柱移动到to柱,借助from柱
            trans(n - 1, temp, to, from);
        }
    }
}

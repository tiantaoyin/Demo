package com.demo.other;

/**
 * Created by ankang on 2017-01-31.
 */
public class HannoTest {
    /**
     * 方法的递归调用--汉诺塔
     */
    public static void main(String[] args) {
        trans(5, 'A', 'B', 'C');
    }

    /**
     * 方法的递归调用--汉诺塔
     *
     * @param i    碟子个数
     * @param from 碟子所在的柱子
     * @param to   碟子将要移动到的柱子
     * @param temp 中间柱
     */
    private static void trans(int i, char from, char to, char temp) {
        if (i == 1) {
            System.out.println(from + "---->" + to);
        } else {
            //把i-1个碟子从from柱移动到temp柱,借助to柱
            trans(i - i, from, temp, to);
            //把1个碟子从from柱移动到to柱
            System.out.println(from + "---->" + to);
            //把i-1个碟子从temp柱移动到to柱,借助from柱
            trans(i - 1, temp, to, from);
        }
    }
}

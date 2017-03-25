package com.demo.other;

import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序+选择排序
 * Created by ankang on 2017-03-25.
 */
public class SortTest {
    public static void main(String[] args) {
        int[] a = {1, 5, 6, 2, 3, 4, 8, 7, 9, 0};

        //快速排序
        Arrays.sort(a);
        output("快速", a);

        //冒泡排序
        bubbleSort(a);
        output("冒泡", a);

        //选择排序
        selectSort(a);
        output("选择", a);
    }

    private static void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    private static void bubbleSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    private static void output(String methodName, int[] a) {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < a.length; i++) {
            System.out.print("a[" + i + "]=" + a[i] + "\t ");
        }
        long endTime = System.currentTimeMillis();
        System.out.println(methodName + "排序耗时 " + (endTime - beginTime) + " 毫秒.");
    }
}

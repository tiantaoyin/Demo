package com.demo.other;

import java.util.Arrays;

/**
 * Created by ankang on 2017-01-31.
 */
public class SortTest {
    /**
     * 冒泡排序与选择排序
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 5, 8, 2, 4, 3, 6, 9, 7};
        //快速排序
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i] + "/t");
        }
        //冒泡排序

        bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i] + "/t");
        }

        //选择排序
        selectSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i] + "/t");
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] a) {
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

    //选择排序
    public static void selectSort(int[] a) {
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
}

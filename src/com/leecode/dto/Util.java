package com.leecode.dto;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/29 11:58
 * @Poject: AlgorithmStudy
 */
public class Util {
    /**
     * 交换元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 交换元素
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swapArr(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    /**
     * 获得指定长度的测试数组
     *
     * @param maxLength
     * @param maxValue
     * @return
     */
    public static int[] getTestArr(int maxLength, int maxValue) {
        maxLength = (int) (Math.random() * maxLength) + 1;
        int[] arr = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            int temp = (int) (Math.random() * maxValue);
            arr[i] = temp;
        }
        return arr;
    }

    /**
     * create by: wangzicheng
     * description: 打印数组
     * create time: 2022/3/23 09:32
     * version: v1.0.0
     */
    public static void printArr(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
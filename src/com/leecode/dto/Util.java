package com.leecode.dto;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/29 11:58
 * @Poject: AlgorithmStudy
 */
public class Util {
    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swapArr(int []arr,int a ,int b){
        arr[a]=arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
}

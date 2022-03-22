package com.leecode.code;

import com.leecode.dto.Util;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.code
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/3/20 11:26
 * @version: 1.0.0
 */
public class Code1_Sort {

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
//        int a = Integer.MIN_VALUE;
//        print(a);

        testMany(10);
    }

    public static void testMany(int times) {
        for (int i = 0; i < times; i++) {
            int[] arr = Util.getTestArr(10, 1000);
            System.out.print("元数据：");
            printArr(arr);
            selectionSort(arr);
            System.out.print("排序数据：");
            printArr(arr);
        }
    }

    /**
     * create by: wangzicheng
     * description: 选择排序
     * create time: 2022/3/20 11:35
     * version: v1.0.0
     */
    public static void selectionSort(int[] arr) {
        if (null == arr || arr.length < 1) {
            return;
        }
        //1--N
        //2--N
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i; j < N; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }

    }

    /**
     * create by: wangzicheng
     * description: 冒泡排序
     * create time: 2022/3/20 11:54
     * version: v1.0.0
     */
    public static void bubbleSort(int[] arr) {
        if (null == arr || arr.length < 1) {
            return;
        }
        int N = arr.length;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1] && j + 1 < N) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * create by: wangzicheng
     * description: 插入排序
     * 将后序无序数字放到合适的有序位置
     * create time: 2022/3/20 12:44
     * version: v1.0.0
     */
    public static void insertSort(int[] arr) {
        if (null == arr || arr.length < 1) {
            return;
        }
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

}

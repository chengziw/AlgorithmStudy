package com.leecode.day;

import com.leecode.dto.Util;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description:
 * @date: 2022/3/28 19:49
 * @version: 1.0.0
 */
public class Day03_28 {

    /**
     * create by: wangzicheng
     * description: 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
     * url: https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
     * create time: 2022/3/28 19:49
     * version: v1.0.0
     */
    public static boolean hasAlternatingBits(int n) {

        int pre = -1;
        for (int i = Double.valueOf(Math.sqrt(n)).intValue(); i >= 0; i--) {
            int b = (n & (1 << i)) == 0 ? 0 : 1;
            System.out.println(b);
            if (pre == b) {
                return false;
            } else {
                pre = b;
            }
            return true;
        }
        return true;
    }

    public static void main(String[] args) {
        hasAlternatingBits(85);
    }

    public static void newSolution(int n) {

        int count = -1;
        while (n != 0) {
            int rightOne = n & ((~n) + 1);
            count++;
            n ^= rightOne;
        }
        int a = n ^ (n >> 1);
        int b = a & (a + 1);
    }

    public static void SelectionSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }

        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i; j < N; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            Util.swap(arr, i, minIndex);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        int N = arr.length;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j + 1] && j + 1 < N) {
                    Util.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0 && arr[j] < arr[j + 1]; j--) {
                Util.swap(arr, j, j + 1);
            }
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (arr == null || start >= end) {
            return;
        }

        int mid = start + (end - start) >> 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        mergeGroups(arr, start, mid, end);
    }

    private static void mergeGroups(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid +1 ;
        int t = 0;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= end) {
            temp[t++] = arr[j++];
        }

        for (int k = 0; k < t; k++) {
            arr[start + k] = temp[k];
        }
    }

}

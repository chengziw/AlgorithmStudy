package com.leecode.sortStudy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/15 13:46
 * @Poject: AlgorithmStudy
 * @description:快速排序
 * 最小时间复杂度：O(nlgn)
 * 最大时间复杂度：O(n²)
 * 平均时间复杂度：O(nlgn)         所有代码执行情况累计  /  所有情况数量
 * 额外空间：o(n)
 * 稳定性：不稳定
 */
public class QuickSort {
    public void quickSortArray(int[] arr, int left, int right) {
        int pivot = 0;
        if (left < right) {
            pivot = getPivot(arr, left, right);
            System.out.println("key："+arr[pivot]+":" + Arrays.toString(arr));
            quickSortArray(arr, left, pivot - 1);
            quickSortArray(arr, pivot + 1, right);
        }
    }

    public int getPivot(int[] arr, int left, int right) {
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }

    @Test
    public void testSort() {
        int[] ints = new int[]{1, 2, 5, 24, 34, 2, 234, 52, 24, 1, 42, 553, 52, 52, 2, 52, 55, 2};
        //quickSortArray(ints,0,ints.length-1);
        System.out.println("原始数据:" + Arrays.toString(ints));
        quickSortArray(ints,0,ints.length-1);
        System.out.println("排序数据" + Arrays.toString(ints));
    }
}

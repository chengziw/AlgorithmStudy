package com.leecode.sortStudy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/14 17:30
 * @Poject: AlgorithmStudy
 * @description:直接选择排序 最小时间复杂度：o(n²)
 * 最大时间复杂度：o(n²)
 * 平均时间复杂度：o(n²)         所有代码执行情况累计  /  所有情况数量
 * 额外空间：o(1)
 * 稳定性：不稳定
 */
public class SelectionSort {
    public void selectSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        Integer[] arr = new Integer[]{1, 10, 3, 8, 6, 7, 9};
        Arrays.sort(arr);
        selectSort(arr);
        long end = System.currentTimeMillis();
        Arrays.asList(arr).forEach(System.out::println);
        System.out.println(end - start);
    }

}

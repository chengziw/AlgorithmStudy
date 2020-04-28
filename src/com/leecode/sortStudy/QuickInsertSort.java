package com.leecode.sortStudy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/17 11:23
 * @Poject: AlgorithmStudy
 * @Description:快速插入排序
 * 最小时间复杂度：O(n)
 * 最大时间复杂度：O(n²)
 * 平均时间复杂度：O(n²)         所有   代码执行情况累计  /  所有情况数量
 * 额外空间：o(1)
 * 稳定性：稳定
 */
public class QuickInsertSort {
    public void quickInserSort(Integer[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];    // 取出下一个元素，在已经排序的元素序列中从后向前扫描
            for (int j = i; j >= 0; j--) {
                if (j > 0 && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];    // 如果该元素（已排序）大于取出的元素temp，将该元素移到下一位置
                   // System.out.println("Temping:  " + Arrays.toString(arr));
                } else {
                    // 将新元素插入到该位置后
                    arr[j] = temp;
                   // System.out.println("Sorting:  " + Arrays.toString(arr));
                    break;
                }
            }
        }

    }

    @Test
    public void testSort() {
        Integer[] arr = new Integer[]{1, 10, 3, 8, 6, 7, 9};
        quickInserSort(arr);
        Arrays.asList(arr).stream().forEach(System.out::println);
    }
}

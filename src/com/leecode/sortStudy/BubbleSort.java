package com.leecode.sortStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/14 15:41
 * @Poject: AlgorithmStudy
 * @description:冒泡排序
 * 最小时间复杂度：o(n)
 * 最大时间复杂度：o(n²)
 * 平均时间复杂度：o(n²)         所有代码执行情况累计  /  所有情况数量
 * 额外空间：o(1)
 * 稳定性：稳定
 */
public class BubbleSort {
    public static void main(String[] args) {
        Integer[] list = {3, 4, 1, 5, 2};
        sortArrays(list);
        Arrays.asList(list).forEach(System.out::println);

    }

    public static void sortArrays(Integer[] ints) {
        if (ints.length < 1) {
            return;
        }
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = 0; j < ints.length - i - 1; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
    }

    //排序优化
    public static void sortArraysBetter(Integer[] ints) {
        Integer[] list = ints;
        int len = list.length - 1;
        int temp = 0; // 开辟一个临时空间, 存放交换的中间值
        int tempPostion = 0;  // 记录最后一次交换的位置
        // 要遍历的次数
        for (int i = 0; i < list.length - 1; i++) {
            int flag = 1; //设置一个标志位
            //依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = 0; j < len; j++) {
                // 比较相邻的元素，如果前面的数小于后面的数，交换
                if (list[j] < list[j + 1]) {
                    temp = list[j + 1];
                    list[j + 1] = list[j];
                    list[j] = temp;
                    flag = 0;  //发生交换，标志位置0
                    tempPostion = j;  //记录交换的位置
                }
                System.out.format("第 %d 遍第%d 趟结果：", i + 1, j + 1);
                for (int count : list) {
                    System.out.print(count);
                }
                System.out.println("");
            }
            len = tempPostion; //把最后一次交换的位置给len，来缩减内循环的次数
            System.out.format("第 %d 遍最终结果：", i + 1);
            for (int count : list) {
                System.out.print(count);
            }
            System.out.println("");
            if (flag == 1) {//如果没有交换过元素，则已经有序
                return;
            }

        }
    }

    public static void getDescription(int[] list) {
        int temp = 0; // 开辟一个临时空间, 存放交换的中间值
        // 要遍历的次数
        for (int i = 0; i < list.length - 1; i++) {
            System.out.format("第 %d 遍：\n", i + 1);
            //依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = 0; j < list.length - 1 - i; j++) {
                // 比较相邻的元素，如果前面的数小于后面的数，就交换
                if (list[j] < list[j + 1]) {
                    temp = list[j + 1];
                    list[j + 1] = list[j];
                    list[j] = temp;
                }
                System.out.format("第 %d 遍的第%d 次交换：", i + 1, j + 1);
                for (int count : list) {
                    System.out.print(count);
                }
                System.out.println("");
            }
            System.out.format("第 %d 遍最终结果：", i + 1);
            for (int count : list) {
                System.out.print(count);
            }
            System.out.println("\n#########################");
        }
    }

}


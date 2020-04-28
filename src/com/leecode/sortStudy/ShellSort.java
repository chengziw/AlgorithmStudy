package com.leecode.sortStudy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/17 17:14
 * @Poject: AlgorithmStudy
 * @Description ：希尔排序
 * 最小时间复杂度：O(n)
 * 最大时间复杂度：O(n²)
 * 平均时间复杂度：O(n3/2)        所有代码执行情况累计  /  所有情况数量
 * 额外空间：o(1)
 * 稳定性：不稳定
 */
public class ShellSort {
    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     * @param arr
     */
    public  void sort(int []arr){
        //增量gap，并逐步缩小增量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<arr.length;i++){
                int j = i;
                while(j-gap>=0 && arr[j]<arr[j-gap]){
                    //插入排序采用交换法
                    swap(arr,j,j-gap);
                    j-=gap;
                }
            }
        }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     * @param arr
     */
    public  void sort1(int []arr){
        //增量gap，并逐步缩小增量
        for(int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0 && temp<arr[j-gap]){
                        //移动法
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public  void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }

    @Test
    public void testShell(){
        int []arr ={1,4,2,7,9,8,};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
        int []arr1 ={1,4,2,7,9,8,};
        sort1(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}

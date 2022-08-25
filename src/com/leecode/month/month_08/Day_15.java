package com.leecode.month.month_08;

import static com.leecode.month.month_06.Day_16.partition;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_08
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/8/15 19:38
 * @version: 1.0.0
 */
public class Day_15 {

    public static void main(String args[]){

        int[] ints = {2,3,15,6,32,7,1,2,3,2,1};
        System.out.println(getMinK(ints,6));

    }

    public static int getMinK(int[] arr,int k){
        int l = 0;
        int r = arr.length - 1;

        int pivot;
        int[] range;
        while (l < r){
            pivot = arr[l + (int) (Math.random() * (r - l + 1))];
            range = partition(arr,l,r,pivot);
            if (k < range[0]){
                r = range[0] -1;
            }else if (k > range[1]){
                l = range[1] + 1;
            }else {
                return pivot;
            }
        }
        return arr[l];
    }

}

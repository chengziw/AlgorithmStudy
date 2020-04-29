package com.leecode.test;

import java.util.*;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/7 17:32
 * @Poject: AlgorithmStudy
 */
public class Solution1 {
    public static void main(String[] args){
        int[] ints=new int[]{1,50,4,13,53,12,232,111};
        getMax(ints,3).forEach(System.out::println);
        getMin(ints,3).stream().forEach(System.out::println);
    }

    public static ArrayList<Integer> getMax(int[] arr, int k){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(arr.length <= 0 || arr == null || arr.length < k) {
            return res;
        }

        for(int i = 0;i < k;i ++) {
            int maxValueIndex = getMaxValueIndex(arr, k);
            if(arr[maxValueIndex] > arr[i]) {
                int temp = arr[maxValueIndex];
                arr[maxValueIndex] = arr[i];
                arr[i] = temp;
            }
        }

        for(int i = 0;i < k;i ++) {
            res.add(arr[i]);
        }
        return res;
    }
    //选择排序：选出最大值的下标
    public static int getMaxValueIndex(int[] arr, int k) {
        int maxValueIndex = k;
        for(int i = k + 1;i < arr.length;i ++) {
            if(arr[i] > arr[maxValueIndex]) {
                maxValueIndex = i;
            }
        }
        return maxValueIndex;
}
    public static List<Integer> getMin(int[] ints, int k){
        List<Integer> result=new ArrayList<>();

        //最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i=0;i<ints.length;i++){
            if(maxHeap.size()<=k){
                maxHeap.add(ints[i]);
            }else if (maxHeap.peek() > ints[i]) {
                maxHeap.poll();
                maxHeap.offer(ints[i]);
            }
        }
        for(Integer n:maxHeap){
            result.add(n);
        }
        return result;
    }

}

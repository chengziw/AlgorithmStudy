package com.leecode.code;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.code
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/3/27 11:24
 * @version: 1.0.0
 */
public class Code07_MergeSort {

    public int[] sortArray(int[] nums) {
        sortArr(nums,0,nums.length-1);
        return nums;
    }

    public void sortArr(int[] nums, int l, int r) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int mid = l + ((l - r) >> 2);
        sortArr(nums, l, mid);
        sortArr(nums, mid + 1, r);
        mergeArr(nums, l, mid, r);
    }

    private void mergeArr(int[] nums, int l, int mid, int r) {
        if (l == r) {
            return;
        }
        int[] temp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1<=mid && p2 <=r){
            temp[i++] = nums[p1]<nums[p2]?nums[p1++]:nums[p2++];
        }

        while (p1<=mid){
            temp[i++] = nums[p1++];
        }

        while (p2<=r){
            temp[i++] = nums[p2++];
        }

        for (int j = 0; j < nums.length; j++) {
            nums[l+i] = temp[j];
        }
    }


    public void sort(int[] arr, int l, int r) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int mid = l + ((r - l) >> 2);
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public void merge(int[] arr, int l, int m, int r) {
        if (l == r) {
            return;
        }
        int[] temp = new int[r - l];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 < r) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 < m) {
            temp[i++] = arr[p1++];
        }
        while (p2 < r) {
            temp[i++] = arr[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            arr[l + j] = temp[j];
        }
    }
}

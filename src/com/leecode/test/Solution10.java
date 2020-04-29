package com.leecode.test;

import org.junit.jupiter.api.Test;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/21 15:05
 * @Poject: AlgorithmStudy
 */
public class Solution10 {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        int len = nums.length;
        for (int i = 0; i < len ; i++) {
            while (nums[i] >0 && nums[i] <= len && nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        int i = 0;

        for (; i < len; i++) {
            if(nums[i] != i+1){
                break;
            }
        }

        return i+1;
    }

    private void swap(int[] nums,int i, int j){
        nums[i] = nums[i]+nums[j];
        nums[j] = nums[i]-nums[j];
        nums[i] = nums[i]-nums[j];
    }

    @Test
    public void testF(){
        int[] arr = new int[]{0,2,2,1,1};
        System.out.println(firstMissingPositive(arr));
    }

}

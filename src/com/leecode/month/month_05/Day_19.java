package com.leecode.month.month_05;

import java.util.Arrays;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_05
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/5/19 20:21
 * @version: 1.0.0
 */
public class Day_19 {

    public int minMoves2(int[] nums) {
        if (nums == null) {
            return 0;
        }

        Arrays.sort(nums);

        int left = nums[0];
        int right = nums[nums.length - 1];

        if (left == right) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int mid = sum / nums.length;
        System.out.println(mid);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - mid);
        }
        return ans;
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}

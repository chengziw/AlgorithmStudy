package com.leecode.pratice;

public class BinaryFindMax {

    public static void main(String[] args) {
        int[] data = {1, 3, 3, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 9, 10, 10, 11, 11, 12, 23, 33, 33, 10, 2, 2, 2, 2, 2, 2, 1, 1, 1};
        int max = findMaxByDichotomy(data);
        System.out.println("max value: " + max);
    }

    /**
     * @author wangzicheng
     * @description: 二分法求极大值
     */
    public static int findMaxByDichotomy(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + ((end - start) >> 1);

            //边界不等正常二分
            if (nums[mid] > nums[mid - 1]) {
                start = mid;
            }
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            }

            //边界相等，推演边界
            if (nums[mid] == nums[mid - 1]) {
                int temp = mid;

                while (nums[mid] == nums[mid - 1]) {
                    mid--;
                }
                if (nums[mid] > nums[mid - 1]) {
                    start = temp;
                } else {
                    end = temp;
                }
            }

            //边界相等，推演边界
            if (nums[mid] == nums[mid + 1]) {
                int temp = mid;
                while (nums[mid] == nums[mid + 1] && mid + 1 < end) {
                    mid++;
                }
                if (nums[mid] < nums[mid + 1]) {
                    start = temp;
                } else {
                    end = temp;
                }

            }
        }
        return Math.max(nums[start], nums[end]);
    }


}
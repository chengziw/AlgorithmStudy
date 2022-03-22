package com.leecode.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.test
 * @author: wangzicheng
 * @description: 移除元素
 * @date: 2022/3/2 4:43 PM
 * @version: 1.0.0
 */
public class Solution15 {
    @Test
    public void test() {
        int[] nums = new int[]{-1, 0, 1, 1, 3, 0, 3, 4, 0, 5, 9, 9, 12, 12, 12, 12};

        //System.out.println(removeDuplicates(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 双指针
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int q = slow; q < nums.length; q++) {
            if (nums[q] != val) {
                nums[slow++] = nums[q];
            }
        }
        return slow;
    }


    /**
     * 26. 删除有序数组中的重复项
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    /**
     * 283.移动零
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 844.比较含退格的字符串
     */
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String str) {
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            if (ch != '#') {
                ret.append(ch);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }


}

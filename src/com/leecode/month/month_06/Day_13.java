package com.leecode.month.month_06;

import com.leecode.dto.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_06
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/6/13 20:23
 * @version: 1.0.0
 */
public class Day_13 {
    public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for (int i = 0; i < heights.length; i++) {
            arr[heights[i]]++;
        }

        int count = 0;

        for (int j = 1, i = 0; i < arr.length; i++) {
            while (arr[j]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }

        return count;
    }


    public int[][] getNearMinValueIndex(int[] arr) {
        int[][] ans = new int[arr.length][2];

        Stack<Integer> minStack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!minStack.isEmpty() && arr[minStack.peek()] > arr[i]) {
                minStack.pop();
                if (minStack.isEmpty()) {
                    ans[i][0] = -1;
                } else {
                    ans[i][0] = minStack.peek();
                }
                ans[i][1] = i;
            }
            minStack.push(i);
        }
        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return nums;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            dummy.next = new ListNode(val % 10);
            dummy = dummy.next;
            carry = val / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val + carry;
            dummy.next = new ListNode(val % 10);
            dummy = dummy.next;
            carry = val / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + carry;
            dummy.next = new ListNode(val % 10);
            dummy = dummy.next;
            carry = val / 10;
            l2 = l2.next;
        }

        if (carry != 0) {
            dummy.next = new ListNode(carry);
        }

        return dummy;
    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(s.charAt(i))) {
                ans = Math.max(ans, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - ans + 1);
        }
        return max;
    }

    /**
     * 在有序数组 nums1 和 nums2 中找到第K小的数字
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

}

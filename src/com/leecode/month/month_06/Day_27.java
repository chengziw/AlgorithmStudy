package com.leecode.month.month_06;

import com.leecode.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_06
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/6/27 18:52
 * @version: 1.0.0
 */
public class Day_27 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 == 1 && nums[right] % 2 == 0) {
                left++;
                right--;
            } else if (nums[left] % 2 == 0 && nums[right] % 2 == 1) {
                swap(nums, left, right);
                left++;
                right--;
            } else if (nums[left] % 2 == 0) {
                right--;
            } else {
                left++;
            }
        }
        return nums;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        morris(root,ans);
        return ans;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        morris(root,ans);
        return ans;
    }

    public void morris(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        TreeNode cur = root;
        TreeNode mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            ans.add(cur.val);
            cur = cur.right;
        }
    }

}

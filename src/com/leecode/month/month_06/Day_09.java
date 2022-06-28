package com.leecode.month.month_06;

import com.leecode.dto.TreeNode;

import java.util.*;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_06
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/6/9 21:08
 * @version: 1.0.0
 */
public class Day_09 {

    public int[] twoSum1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int y = twoSumDFS(nums, target - x, i);
            if (y != -1) {
                return new int[]{i, y};
            }
        }
        return nums;
    }

    public int twoSumDFS(int[] dfs, int target, int index) {
        if (target == 0) {
            return -1;
        }

        for (int i = index; i < dfs.length; i++) {
            if (dfs[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        int lower;
        while (true) {

            lower = a ^ b;
            int carrier = (a & b) << 1;
            if (carrier == 0) {
                break;
            }
            a = lower;
            b = carrier;
        }
        return lower;
    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int x = target - numbers[i];
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        if (root.val == k) {
            return true;
        }
        boolean flag = findTarget(root.left, k - root.val) || findTarget(root.right, k - root.val);

        if (flag) {
            return true;
        } else {
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                int sum = nums[i] + nums[r] + nums[l];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }
            }

        }
        return res;
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == nums || nums.length < 4) {
            return res;
        }
        int length = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > target) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = length - 1;
            while (l < r) {
                int sum = nums[i] + nums[r] + nums[l];
                int s = target - sum;
                if (map.containsKey(s) && map.get(s) > i && map.get(s) != l && map.get(s) != r) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r], nums[map.get(s)]));
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }
            }
        }
        return res;
    }

    public void fourSumDFS(int[] nums, int index, int target) {
        if (index == nums.length || target == 0) {

        }
    }

    public int sum(int num1, int num2) {
        if (num1 < 0 || num2 < 0) {
            return num1 + num2;
        }

        if (num1 == 0) {
            return num2;
        }

        if (num2 == 0) {
            return num1;
        }

        int lower;
        while (true) {
            lower = num1 ^ num2;
            int carrider = (num1 & num2) << 1;
            if (carrider == 0) {
                break;
            }
            num1 = lower;
            num2 = carrider;
        }
        return lower;
    }
}

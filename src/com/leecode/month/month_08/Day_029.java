package com.leecode.month.month_08;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_08
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/8/29 19:30
 * @version: 1.0.0
 */
public class Day_029 {


    public int maxPoints(int[] arr, int length) {
        int left = 0;
        int right = 0;
        int N = arr.length;
        int max = 0;

        while (left < N) {
            while (right < N && arr[right] - arr[left] <= length) {
                right++;
            }

            max = Math.max(max, right - left);
            left++;
        }
        return max;
    }

    public int getFileNumber(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return 0;
        }

        if (!file.isDirectory() && !file.isFile()) {
            return 0;
        }

        if (file.isFile()) {
            return 1;
        }

        Stack<File> stack = new Stack<>();
        stack.add(file);
        int ans = 0;
        while (!stack.isEmpty()) {

            File f = stack.pop();
            for (File files : Objects.requireNonNull(f.listFiles())) {
                if (files.isDirectory()) {
                    stack.add(files);
                }

                if (files.isFile()) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public int getTableSizeFor(int n) {
        n--;

        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return n < 0 ? 1 : n + 1;
    }


    public int process1(int[] arr, int index, int reset) {
        if (index == arr.length) {
            return reset == 0 ? 1 : 0;
        }

        return process1(arr, index + 1, reset - arr[index]) + process1(arr, index + 1, reset + arr[index]);
    }


    public int findTargetWay(int[] arr, int target) {
        return process2(arr, 0, target, new HashMap<>());
    }

    public int process2(int[] arr, int index, int reset, HashMap<Integer, HashMap<Integer, Integer>> dp) {
        if (dp.containsKey(index) && dp.get(index).containsKey(reset)) {
            return dp.get(index).get(reset);
        }

        int ans = 0;
        if (index == arr.length) {
            ans = reset == 0 ? 1 : 0;
        } else {
            ans = process2(arr, index + 1, reset - arr[index], dp) + process2(arr, index + 1, reset + arr[index], dp);
        }

        if (!dp.containsKey(index)) {
            dp.put(index, new HashMap<>());
        }

        dp.get(index).put(reset, ans);
        return ans;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return 0;
    }

    public int subSet(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[s];
    }
}

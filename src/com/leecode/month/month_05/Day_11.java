package com.leecode.month.month_05;

import java.util.*;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_05
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/5/11 20:33
 * @version: 1.0.0
 */
public class Day_11 {

    public int minCostToMoveChips(int[] position) {
        int count = 0;
        for (int n : position) {
            count += n & 1;
        }
        int count1 = position.length - count;
        return Math.min(count1, count1);
    }

    public int balancedStringSplit(String s) {
        if (s == null) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                left++;
            } else {
                right++;
            }
            if (left > 0 && left == right) {
                ans++;
                left = 0;
                right = 0;
            }
        }
        return ans;
    }

    public List<Integer> minSubsequence(int[] nums) {
        if (nums == null) {
            return null;
        }

        PriorityQueue<Integer> queue = new PriorityQueue((Comparator<Integer>) (o1, o2) -> o2 - o1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            sum += nums[i];
        }
        int ans = 0;
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty() && ans < sum >> 1) {
            ans += queue.peek();
            result.add(queue.poll());
        }
        return result;
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        int count = 0;
        for (int[] box : boxTypes) {
            if (box[0] < truckSize) {
                count += box[0] * box[1];
                truckSize -= box[0];
            } else {
                count += truckSize * box[1];
                return count;
            }
        }
        return count;
    }
}

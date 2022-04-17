package com.leecode.sortStudy.codeTest;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.sortStudy.codeTest
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/16 12:19
 * @version: 1.0.0
 */
public class Day04_16 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int s = 0;
        int b = 0;
        int[] ans = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            if (s < m && b < n) {
                ans[i] = Math.min(nums1[s], nums2[b]);
                if (ans[i] == nums1[s]) {
                    s++;
                } else {
                    b++;
                }
            } else if (s >= m) {
                ans[i] = nums2[b];
                b++;
            } else if (b >= n) {
                ans[i] = nums1[s];
                s++;

            }
        }
        for (int i = 0; i < ans.length; i++) {
            nums1[i] = ans[i];
        }

    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        int n = nums.length >> 1;
        for (Map.Entry map : hashMap.entrySet()) {
            if ((int) map.getValue() > n) {
                return (int) map.getKey();
            }
        }
        return -1;
    }

    /**
     * create by: wangzicheng
     * description: 投票法
     * create time: 2022/4/16 14:05
     * version: v1.0.0
     */
    public int majorityElement1(int[] nums) {
        int count = 0;
        Integer can = null;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                can = nums[i];
            }

            count += (nums[i] == can) ? 1 : -1;
        }
        return can;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() == nums.length;
    }

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }

        char[] chars1 = t.toCharArray();
        for (int j = 0; j < chars1.length; j++) {
            if (!map.containsKey(chars1[j])) {
                return false;
            }
            if (map.get(chars1[j]) < 1) {
                return false;
            } else {
                map.put(chars1[j], map.getOrDefault(chars1[j], 0) - 1);
            }
        }

        for (Map.Entry m : map.entrySet()) {
            if ((int) m.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public int missingNumber(int[] nums) {
        int sum = (nums.length + 1) * (nums.length) >> 1;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        list.retainAll(set2);
        set1.addAll(list);
        return set1.stream().mapToInt(i -> i).toArray();

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l1 = nums1.length;
        int l2 = nums2.length;

        int[] ans = new int[l1 + l2];

        int index = 0, index1 = 0, index2 = 0;

        while (index1 < l1 && index2 < l2) {
            int value1 = nums1[index1];
            int value2 = nums2[index2];
            if (value1 == value2) {
                ans[index] = value1;
                index++;
                index1++;
                index2++;
            } else if (value1 < value1) {
                index1++;
            } else {
                index2++;
            }
        }

        return Arrays.copyOfRange(ans, 0, index);
    }

    public char findTheDifference(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return c2[i];
            }
        }

        return c2[c2.length];
    }

    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max1) {
                max1 = nums[i];
            } else if (nums[i] >= max2 && nums[i] < max1) {
                max2 = nums[i];
            } else if (nums[i] > max3 && nums[i] < max2) {
                max3 = nums[i];
            }
        }

        return max3 == Integer.MIN_VALUE ? Math.max(max1, max2) : max3;
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sum = 0;
        int index = 0;
        for (int i = 0; i < s.length && index < g.length; i++) {
            if (s[i] >= g[index]) {
                sum++;
                index++;
            }
        }
        return sum;
    }

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            if (i >= 3) {
                ans[arr[i][1]] = Integer.toString(i + 1);
            } else {
                ans[arr[i][1]] = desc[i];
            }
        }
        return ans;
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }


    @Test
    public void test() {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}

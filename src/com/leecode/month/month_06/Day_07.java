package com.leecode.month.month_06;

import com.leecode.dto.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_06
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/6/7 18:38
 * @version: 1.0.0
 */
public class Day_07 {

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int min = 1;
        int res = max;
        while (min < max) {
            int speed = (max - min) / 2 + min;
            int ret = getTime(speed, piles);

            if (ret <= h) {
                max = speed;
                res = speed;
            } else {
                min = speed + 1;
            }
        }
        return res;
    }

    public int getTime(int speed, int[] piles) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += (piles[i] + speed - 1) / speed;
        }
        return time;
    }


    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int j = 0; j < nums.length; j++) {
                c += (nums[j] >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }

    public int numDistinct(String s, String t) {
        char[] chars = s.toCharArray();
        int ans = 0;
        deal(chars, 0, ans, "", t);
        return ans;
    }

    public void deal(char[] chars, int index, int ans, String path, String t) {
        if (index == chars.length && t.equals(path)) {
            ans++;
            return;
        }
        deal(chars, index + 1, ans, path, t);
        deal(chars, index + 1, ans, path + chars[index + 1], t);
    }

    @Test
    public void testString() {
        String str = "abc";
        char[] chars = str.toCharArray();
        List<String> ans = new ArrayList<>();
        testStringSplit(chars, 0, ans);
        ans.stream().forEach(e -> System.out.println(e));

    }

    public void testStringSplit(char[] chars, int index, List<String> ans) {
        if (index == chars.length) {
            ans.add(String.valueOf(chars));
        }

        for (int i = index; i < chars.length; i++) {
            Util.swapChar(chars, i, index);
            testStringSplit(chars, index + 1, ans);
            Util.swapChar(chars, index, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ret.add(nums[i]);
        }

        dealPermute(0, ans, ret);
        return ans;
    }

    public void dealPermute(int index, List<List<Integer>> ans, List<Integer> path) {
        if (path.size() == index) {
            ans.add(new ArrayList<>(path));
        }

        for (int i = index; i < path.size(); i++) {
            Collections.swap(path, index, i);
            dealPermute(index + 1, ans, path);
            Collections.swap(path, i, index);
        }
    }


    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            ret.add(nums[i]);
        }
        dealPermuteUnique(ret, ans, 0);
        return ans;
    }

    public void dealPermuteUnique(List<Integer> path, List<List<Integer>> ans, int index) {
        if (path.size() == index) {
            ans.add(new ArrayList<>(path));
        }

        boolean[] visit = new boolean[21];
        for (int i = index; i < path.size(); i++) {
            System.out.println(path.get(i) + 10);
            if (!visit[path.get(i) + 10]) {
                visit[path.get(i) + 10] = true;
                Collections.swap(path, index, i);
                dealPermuteUnique(path, ans, index + 1);
                Collections.swap(path, i, index);
            }
        }

    }

    @Test
    public void testZP() {
        int[] ints = new int[]{10, 100, 5, 6};
        System.out.println(Math.max(f(ints, 0, ints.length - 1), b(ints, 0, ints.length - 1)));
    }

    public int f(int[] ints, int l, int r) {
        if (l == r) {
            return ints[l];
        }

        return Math.max(ints[l] + b(ints, l + 1, r), ints[r] + b(ints, l, r - 1));
    }

    public int b(int[] ints, int l, int r) {
        if (l == r) {
            return 0;
        }

        return Math.min(f(ints, l + 1, r), f(ints, l, r - 1));
    }

}

package com.leecode.month.month_05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_05
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/5/6 17:18
 * @version: 1.0.0
 */
public class Day_06 {

    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }
        int ans = 0;
        for (int j : count) {
            ans += j / 2 * 2;
            if (j % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    @Test
    public void test() {

    }
}

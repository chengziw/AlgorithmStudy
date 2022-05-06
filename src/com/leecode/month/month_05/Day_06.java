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
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean flag = false;
        int ans = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1] && i + 1 < chars.length) {
                ans += 2;
                i++;
            } else {
                flag = true;
            }
        }
        return ans + (flag ? 1 : 0);
    }

    @Test
    public void test(){

    }
}

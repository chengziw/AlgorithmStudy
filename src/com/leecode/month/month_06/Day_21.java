package com.leecode.month.month_06;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_06
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/6/21 20:56
 * @version: 1.0.0
 */
public class Day_21 {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }

        int r = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int[] arr = new int[sb.length()];
        String str = sb.toString();
        for (int i = 0; i < str.length(); i++) {

            arr[i] = r > i ? Math.min(arr[2 * c - i], r - i) : 1;
            while (i + arr[i] < sb.length() && i - arr[i] > -1) {
                if (str.charAt(i + arr[i]) == str.charAt(i - arr[i])) {
                    arr[i]++;
                } else {
                    break;
                }
            }

            if (i + arr[i] > r) {
                r = i + arr[i];
                c = i;
            }

            if (c * 2 + 1 > end - start) {
                start = i - c;
                end = i + c;
            }
            max = Math.max(max, arr[i]);

        }


        return sb.substring(start, end).replace("#", "");
    }

    @Test
    public void test() {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

    public String longestPalindromeRight(String s) {
        int start = 0, end = -1;
        StringBuffer t = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

        List<Integer> arm_len = new ArrayList<>();
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int cur_arm_len;
            if (right >= i) {
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }

    public int longestPalindromeSubseq(String s) {
        int[] ans = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ans[chars[i] - 'a']++;
        }

        boolean flag = true;
        int result = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] % 2 == 0) {
                result += ans[i];
            } else if (flag) {
                result += ans[i];
                flag = false;
            } else {
                result += ans[i] - 1;
            }
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        String str = s.replace(" ", "") + s.replace(" ", "");
        return str.contains(s);
    }

}

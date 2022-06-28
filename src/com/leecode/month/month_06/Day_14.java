package com.leecode.month.month_06;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_06
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/6/15 18:52
 * @version: 1.0.0
 */
public class Day_14 {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                int i = binarySearch(nums, j, nums[j] - mid);
                cnt += j - i;
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int binarySearch(int[] nums, int end, int target) {
        int left = 0, right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    @Test
    public void test() {
        System.out.println(getIndex("mississippi", "issip"));
    }

    // O(N)
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str = s.toCharArray();
        char[] match = m.toCharArray();
        int x = 0; // str中当前比对到的位置
        int y = 0; // match中当前比对到的位置
        // M  M <= N   O(M)
        int[] next = getNextArray(match); // next[i]  match中i之前的字符串match[0..i-1]
        // O(N)
        while (x < str.length && y < match.length) {
            if (str[x] == match[y]) {
                x++;
                y++;
            } else if (next[y] == -1) { // y == 0
                x++;
            } else {
                y = next[y];
            }
        }
        return y == match.length ? x - y : -1;
    }
//
//    // M   O(M)
//    public static int[] getNextArray(char[] match) {
//        if (match.length == 1) {
//            return new int[]{-1};
//        }
//        int[] next = new int[match.length];
//        next[0] = -1;
//        next[1] = 0;
//        int i = 2;
//        // cn代表，cn位置的字符，是当前和i-1位置比较的字符
//        int cn = 0;
//        while (i < next.length) {
//            if (match[i - 1] == match[cn]) { // 跳出来的时候
//                next[i++] = ++cn;
//            } else if (cn > 0) {
//                cn = next[cn];
//            } else {
//                next[i++] = 0;
//            }
//        }
//        return next;
//    }

    private static int[] getNextArray(char[] match) {
        if (match.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[match.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (match[i - 1] == match[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }


    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        char[] str = haystack.toCharArray();
        char[] match = needle.toCharArray();

        int x = 0;
        int y = 0;
        int[] next = getNextArray(match);

        while (x < str.length && y < match.length) {
            if (str[x] == match[y]) {
                x++;
                y++;
            } else if (y == 0) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == match.length ? x - y : -1;
    }


    public int repeatedStringMatch(String a, String b) {
        int an = a.length(), bn = b.length();
        int index = strStr(a, b);
        if (index == -1) {
            return -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }

    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return strStr(str.substring(1, str.length() - 1), s) == -1;
    }

    public int getIndex(String str, String match) {
        if (str == null || match == null || str.length() < 1 || match.length() < 1) {
            return -1;
        }
        char[] s = str.toCharArray();
        char[] m = match.toCharArray();

        int x = 0;
        int y = 0;
        int[] next = getNext(m);

        while (x < s.length && y < match.length()) {
            if (s[x] == m[y]) {
                x++;
                y++;
            } else if (y == 0) {
                x++;
            } else {
                y = next[y];
            }
        }

        return y == m.length ? x - y : -1;
    }

    private int[] getNext(char[] m) {
        if (m.length < 1) {
            return new int[]{-1};
        }

        int[] ans = new int[m.length];
        ans[0] = -1;
        ans[1] = 0;
        int i = 2;
        int cnt = 0;
        while (i < m.length) {
            if (m[i - 1] == m[cnt]) {
                ans[i++] = ++cnt;
            } else if (cnt > 0) {
                cnt = ans[cnt];
            } else {
                ans[i++] = 0;
            }
        }
        return ans;
    }

}

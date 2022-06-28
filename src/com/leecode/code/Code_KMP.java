package com.leecode.code;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.code
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/6/15 23:16
 * @version: 1.0.0
 */
public class Code_KMP {

    public int getIndexOf(String str, String match) {
        if (str == null || match == null || match.length() > str.length()) {
            return -1;
        }
        char[] s = str.toCharArray();
        char[] m = match.toCharArray();

        int x = 0;
        int y = 0;
        int[] next = getNextArr(m);
        while (x < s.length && y < m.length) {
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

    private int[] getNextArr(char[] match) {
        if (match.length == 1) {
            return new int[]{-1};
        }

        int[] ans = new int[match.length];
        ans[0] = -1;
        ans[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < match.length) {
            if (match[i - 1] == match[cn]) {
                ans[i++] = ++cn;
            } else if (cn > 0) {
                cn = ans[cn];
            } else {
                ans[i++] = 0;
            }
        }
        return ans;
    }
}

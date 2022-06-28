package com.leecode.month.month_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_06
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/6/12 13:37
 * @version: 1.0.0
 */
public class Day_12 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<String>();
        for (String word : words) {
            if (match(word, pattern) && match(pattern, word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    public boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < word.length(); ++i) {
            char x = word.charAt(i), y = pattern.charAt(i);
            if (!map.containsKey(x)) {
                map.put(x, y);
            } else if (map.get(x) != y) { // word 中的同一字母必须映射到 pattern 中的同一字母上
                return false;
            }
        }
        return true;
    }


    /**
     * @author wangzicheng
     * @description: 最长公共子序列
     * @date 2022/6/12 15:53
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        int[][] dp = new int[text1.length()][text2.length()];
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        dp[0][0] = c1[0] == c2[0] ? 1 : 0;
        for (int i = 1; i < c1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], c1[i] == c2[0] ? 1 : 0);
        }

        for (int i = 1; i < c2.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], c2[i] == c1[0] ? 1 : 0);
        }

        for (int i = 1; i < c1.length; i++) {
            for (int j = 1; j < c2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                if (c1[i] == c2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[c1.length-1][c2.length-1];
    }
}

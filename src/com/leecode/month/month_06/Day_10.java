package com.leecode.month.month_06;

import java.util.Arrays;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_06
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/6/10 19:12
 * @version: 1.0.0
 */
public class Day_10 {
    public int countPalindromicSubsequences(String s) {
        final int MOD = 1000000007;
        int n = s.length();
        int[][][] dp = new int[4][n][n];
        for (int i = 0; i < n; i++) {
            dp[s.charAt(i) - 'a'][i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                for (char c = 'a'; c <= 'd'; c++) {
                    int k = c - 'a';
                    if (s.charAt(i) == c && s.charAt(j) == c) {
                        dp[k][i][j] = (2 + (dp[0][i + 1][j - 1] + dp[1][i + 1][j - 1]) % MOD + (dp[2][i + 1][j - 1] + dp[3][i + 1][j - 1]) % MOD) % MOD;
                    } else if (s.charAt(i) == c) {
                        dp[k][i][j] = dp[k][i][j - 1];
                    } else if (s.charAt(j) == c) {
                        dp[k][i][j] = dp[k][i + 1][j];
                    } else {
                        dp[k][i][j] = dp[k][i + 1][j - 1];
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 4; i++) {
            res = (res + dp[i][0][n - 1]) % MOD;
        }
        return res;
    }


    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] rest = new int[capacity.length];
        for (int i = 0; i < rest.length; i++) {
            rest[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(rest);

        int ans = 0;
        for (int i = 0; i < rest.length; i++) {
            if (rest[i] == 0) {
                continue;
            }
            if (additionalRocks <= 0) {
                break;
            }

            int res = additionalRocks - rest[i];
            if (res > 0) {
                additionalRocks = res;
                ans++;
            }
        }
        return ans;
    }


}

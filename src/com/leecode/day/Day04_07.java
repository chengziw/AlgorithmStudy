package com.leecode.day;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description: https://leetcode-cn.com/problems/rotate-string/
 * @date: 2022/4/7 17:38
 * @version: 1.0.0
 */
public class Day04_07 {

    public boolean rotateString(String s, String goal) {
        if (s == null && goal == null) {
            return true;
        }

        if (s == null || goal == null || s.length() != goal.length()) {
            return false;
        }

        char[] chars = goal.toCharArray();
        int N = s.length();

        for (int i = 0; i < chars.length; i++) {
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                if ((s.charAt(i + j) % N) != chars[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                return true;
            }
        }
        return false;

      //  return s.length() == goal.length() && (s + s).contains(goal);
    }

}

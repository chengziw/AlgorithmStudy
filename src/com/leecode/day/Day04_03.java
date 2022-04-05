package com.leecode.day;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description: 744. 寻找比目标字母大的最小字母
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 * @date: 2022/4/3 16:38
 * @version: 1.0.0
 */
public class Day04_03 {
    public char nextGreatestLetter(char[] letters, char target) {
        int N = letters.length;
        if (target > letters[N - 1]) {
            return letters[0];
        }

        int left = 0;
        int right = N - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return letters[left];
    }

    /**
     * create by: wangzicheng
     * description: https://leetcode-cn.com/problems/wildcard-matching/
     * create time: 2022/4/3 16:49
     * version: v1.0.0
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        if (p.contains("*")) {
            return true;
        }
        if (p.length() != s.length()){
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != p.charAt(i) && p.charAt(i) !='*'){
                return false;
            }
        }
        return true;
    }
}

package com.leecode.day;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description:
 * @date: 2022/3/28 19:49
 * @version: 1.0.0
 */
public class Day03_28 {

    /**
     * create by: wangzicheng
     * description: 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
     * url: https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
     * create time: 2022/3/28 19:49
     * version: v1.0.0
     */
    public static boolean hasAlternatingBits(int n) {

        int pre = -1;
        for (int i = Double.valueOf(Math.sqrt(n)).intValue(); i >= 0; i--) {
            int b = (n & (1 << i)) == 0 ? 0 : 1;
            System.out.println(b);
            if (pre == b) {
                return false;
            }else {
                pre = b;
            }
            return true;
        }
        return true;
    }

    public static void main(String[] args) {
        hasAlternatingBits(85);
    }
}

package com.leecode.test;

import org.junit.jupiter.api.Test;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.test
 * @author: wangzicheng
 * @description: 求x的n次方
 * @date: 2022/2/28 4:50 PM
 * @version: 1.0.0
 */
public class Solution13 {

    @Test
    public void test1() {
        int x = 2;
        int n = 4;

        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * x;
        }
        System.out.println(function5(x, n));
    }


    public int test2(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return test2(x, n - 1) * x;
    }

    public int function3(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return function3(x, n / 2) * function3(x, n / 2) * x;
        }
        return function3(x, n / 2) * function3(x, n / 2);
    }

    int function4(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int t = function4(x, n / 2);// 这里相对于function3，是把这个递归操作抽取出来
        if (n % 2 == 1) {
            return t * t * x;
        }
        return t * t;
    }

    int function5(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int t = function5(x, n / 2);
        if (t % 2 == 1) {
            return t * t * x;
        }
        return t * t;
    }


}

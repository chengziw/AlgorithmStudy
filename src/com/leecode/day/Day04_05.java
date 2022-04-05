package com.leecode.day;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description: https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 * @date: 2022/4/5 14:14
 * @version: 1.0.0
 */
public class Day04_05 {

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (isPrimeNew(shiZhiShu(i))){
                ans ++ ;
            }
        }
        return ans;
    }

    public int shiZhiShu(int n) {
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            ans += (n & (n << i)) == 0 ? 0 : 1;
        }
        return ans;
    }

    public boolean isPrimeNew(int x) {
        for (int i = x; i < x * x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }


    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }



}

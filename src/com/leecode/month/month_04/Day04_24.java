package com.leecode.month.month_04;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/24 20:45
 * @version: 1.0.0
 */
public class Day04_24 {
    public int binaryGap1(int n) {
        int last = -1, ans = 0;
        for (int i = 0; n != 0; ++i) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return ans;
    }


    public int binaryGap(int n) {
        int pre = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if ((n &(1>>i)) == 1){
                ans = Math.max(ans,i-pre);
                pre = i;
            }
        }
        return ans;
    }
}

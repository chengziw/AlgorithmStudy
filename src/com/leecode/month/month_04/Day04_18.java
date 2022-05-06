package com.leecode.month.month_04;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/18 21:24
 * @version: 1.0.0
 */
public class Day04_18 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ret.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ret;
    }
}

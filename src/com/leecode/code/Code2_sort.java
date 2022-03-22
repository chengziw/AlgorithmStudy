package com.leecode.code;

import java.util.HashMap;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.code
 * @author: wangzicheng
 * @description: 有一个 1-5的等概率随即数函数，获取1-7的等概率函数
 * @date: 2022/3/22 09:33
 * @version: 1.0.0
 */
public class Code2_sort {

    public static int code1() {
        return (int) (Math.random() * 5.0) + 1;
    }

    public static int code2() {
        int result;
        do {
            result = code1();
        } while (result == 3);
        return result < 3 ? 0 : 1;
    }

    public static int code3() {
        int a = (code2() << 2);
        int b = (code2() << 1);
        return a + b + code2();
    }

    public static int code4() {
        int result;
        do {
            result = code3();
        } while (result == 0);
        return result;
    }

    public static void main(String args[]) {

        int times = 10000000;
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < times; i++) {
            Integer value = code4();
            result.put(value, result.getOrDefault(value, 0) + 1);
        }
        for (Integer key : result.keySet()) {
            System.out.println(key + ":" + result.get(key));
        }
    }

}

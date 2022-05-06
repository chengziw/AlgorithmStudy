package com.leecode.month.month_04;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/4/1 19:45
 * @version: 1.0.0
 */
public class Day04_01 {

    public static final String BEAN_NAME = "nacosValueAnnotationBeanPostProcessor";

    private static final String SPEL_PREFIX = "#{";

    private static final String PLACEHOLDER_PREFIX = "${";

    private static final String PLACEHOLDER_SUFFIX = "}";

    private static final char PLACEHOLDER_MATCH_PREFIX = '{';

    private static final char PLACEHOLDER_MATCH_SUFFIX = '}';

    private static final String VALUE_SEPARATOR = ":";


    @Test
    public void test() {
        System.out.println(resolveExpr("1474282166849376299:5"));
    }

    private String resolveExpr(String nacosValueExpr) {
        try {
            int replaceHolderBegin = nacosValueExpr.indexOf(PLACEHOLDER_PREFIX) + PLACEHOLDER_PREFIX.length();
            int replaceHolderEnd = replaceHolderBegin;
            for (int i = 0; replaceHolderEnd < nacosValueExpr.length(); replaceHolderEnd++) {
                char ch = nacosValueExpr.charAt(replaceHolderEnd);
                if (PLACEHOLDER_MATCH_PREFIX == ch) {
                    i++;
                } else if (PLACEHOLDER_MATCH_SUFFIX == ch && --i == -1) {
                    break;
                }
            }
            String replaceHolder = nacosValueExpr.substring(replaceHolderBegin, replaceHolderEnd);
            int separatorIndex = replaceHolder.indexOf(VALUE_SEPARATOR);
            if (separatorIndex != -1) {
                return nacosValueExpr.substring(0, separatorIndex + replaceHolderBegin) + nacosValueExpr.substring(replaceHolderEnd);
            }
            return nacosValueExpr;
        } catch (Exception e) {
            throw new IllegalArgumentException("The expr format is illegal, expr: " + nacosValueExpr, e);
        }
    }

    /**
     * create by: wangzicheng
     * description:
     * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足
     * “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/array-of-doubled-pairs
     * create time: 2022/4/1 22:21
     * version: v1.0.0
     */
    public boolean canReorderDoubledError(int[] arr) {
        if (arr == null || arr.length < 1) {
            return false;
        }

        int N = arr.length;
        Map<Integer, Integer> hashMap = new HashMap<>(N);

        for (int i = 0; i < N; i++) {
            int key = arr[i];
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key));
            } else {
                hashMap.put(key, 1);
            }
        }

        int l = N >> 1;
        for (int j = 0; j < l; j++) {
            if (hashMap.get(arr[j])<=0){
                l++;
                continue;
            }
            int key = 2 * arr[j];
            if (!hashMap.containsKey(key) || hashMap.get(key) <= 0) {
                key = arr[j] >> 1;
                if (!hashMap.containsKey(key) || hashMap.get(key) <= 0) {
                    return false;
                }
            }
            hashMap.put(arr[j], hashMap.get(key) - 1);
            hashMap.put(key, hashMap.get(key) - 1);
        }
        return true;
    }

    @Test
    public void testCanReorderDoubled(){
        System.out.println(canReorderDoubled(new int[]{1,2,2,16,8,4}));
    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }

        List<Integer> vals = new ArrayList<>();
        for (int x : cnt.keySet()) {
            vals.add(x);
        }
        Collections.sort(vals, (a, b) -> Math.abs(a) - Math.abs(b));

        for (int x : vals) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) { // 无法找到足够的 2x 与 x 配对
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }

}

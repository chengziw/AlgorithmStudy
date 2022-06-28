package com.leecode.month.month_06;

import org.junit.jupiter.api.Test;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_06
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/6/17 09:22
 * @version: 1.0.0
 */
public class Day_17 {

    @Test
    public void test() {
        int ans = getMinK(new int[]{1, 13, 5, 71, 22, 4, 6, 8}, 3);
        System.out.println(ans);
    }

    public int getMinK(int[] arr, int k) {
        if (arr == null || k < 0) {
            return -1;
        }
        return getMinKDeal(arr, 0, arr.length - 1, k);
    }

    public int getMinKDeal(int[] arr, int l, int r, int k) {
        if (l == r) {
            return l;
        }

        int rand = arr[l + (int) (Math.random() * (r - l + 1))];
        int[] partition = getPartition(arr, l, r, rand);

        if (k >= partition[0] && partition[1] >= k) {
            return arr[k];
        } else if (k < partition[0]) {
            return getMinKDeal(arr, l, partition[0] - 1, k);
        } else {
            return getMinKDeal(arr, partition[1] + 1, r, k);
        }
    }

    private int[] getPartition(int[] arr, int l, int r, int rand) {
        int less = l - 1;
        int more = r + 1;

        int cur = l;
        while (cur < more) {
            if (arr[cur] < rand) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > rand) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}

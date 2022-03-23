package com.leecode.code;

import com.leecode.dto.Util;
import org.junit.jupiter.api.Test;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.code
 * @author: wangzicheng
 * @description: 局部最小问题
 * @date: 2022/3/23 09:22
 * @version: 1.0.0
 */
public class Code3_Sort {

    @Test
    public void testFindMinIndex() {
        int times = 1000;

        for (int i = 0; i < times; i++) {
            int[] arr = Util.getTestArr(10, 100);
            Util.printArr(arr);
            System.out.println(i+":"+findMinIndex(arr));
        }

    }


    public int findMinIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1) {
            return 0;
        }

        int N = arr.length;
        if (arr[0] < arr[1]) {
            return 0;
        }

        if (arr[N - 2] > arr[N - 1]) {
            return N - 1;
        }

        int L = 0;
        int R = N - 1;
        while (L < R - 1) {
            int mid = (R - L) / 2;
            if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }

        return arr[L] < arr[R] ? L : R;
    }
}

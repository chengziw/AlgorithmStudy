package com.leecode.day;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/3/31 17:21
 * @version: 1.0.0
 */
public class Day03_31 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        if (left > right) {
            return null;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isAns(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isAns(int num) {

        int n = num;
        while (n > 0) {
            int r = n % 10;
            if (r == 0 || num % r != 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    @Test
    public void test() {
        List<Integer> integers = selfDividingNumbers(1, 22);
        if (integers != null)
            integers.forEach(integer -> System.out.println(integer));
    }


    public void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) >> 1;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        mergeArr(arr, l, mid, r);
    }

    private void mergeArr(int[] arr, int l, int mid, int r) {
        int[] ans = new int[r - l + 1];
        int i = l;
        int j = r;
        int t = 0;
        while (i <= l && j <= r) {
            ans[t++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= l) {
            ans[t++] = arr[i++];
        }

        while (j <= r) {
            ans[t++] = arr[j++];
        }

        for (int k = 0; k < t; k++) {
            arr[l + k] = arr[k];
        }
    }

    public void quickSort(int[] arr, int l, int r) {
        while (l < r) {
            int indexMid = getIndexMid(arr, l, r);
            quickSort(arr, l, indexMid);
            quickSort(arr, indexMid + 1, r);
        }
    }

    private int getIndexMid(int[] arr, int l, int r) {
        int key = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= key) {
                r--;
            }

            arr[l] = arr[r];

            while (l<r && arr[l]<= key){
                l ++;
            }
            arr[r] = arr[l];
        }
        arr[l] = key;
        return l;
    }
}

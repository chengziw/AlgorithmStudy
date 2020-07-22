package com.leecode.pratice;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        int[] ints=new int[]{5,3,6,7,4,8,2,1};
        quickSort(ints,0,ints.length-1);
        System.out.println("排序数据" + Arrays.toString(ints));
    }
    public static void quickSort(int[] ints,int lo,int hi){
        int mid=0;
        if (lo<hi){
            mid=getMid(ints,lo,hi);
            quickSort(ints,lo,mid-1);
            quickSort(ints,mid+1,hi);
        }
    }

    private static int getMid(int[] ints, int lo, int hi) {
        int key=ints[lo];

        while (lo<hi){
            while (lo<hi&&ints[hi]>=key) hi--;
            ints[lo]=ints[hi];
            while (lo<hi&&ints[lo]<=key) lo++;
            ints[hi]=ints[lo];
        }
        ints[lo]=key;
        return lo;
    }
}

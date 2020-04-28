package com.leecode.pratice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangzicheng
 * @Date: 2020/4/13 16:35
 * @Poject: AlgorithmStudy
 */
public class Practice2 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 6, 8, 10, 11};
        int[] b = new int[]{2, 5, 7, 9, 10, 12, 16, 18};
        List<Integer> list=new ArrayList<>();
        if (list != null) {

        }
        System.out.println(asciiToString(a, b));
    }

    public static double asciiToString(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m < n) {
            int temp[] = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halftLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i=(iMax+iMin)/2;
            int j=halftLen-i;
            if(i<iMax&&B[j-1]>A[i]){
                iMin=i+1;
            }else if(i>iMin&&A[i-1]>B[j]){
                iMax=i-1;
            }else {
                int maxLeft=0;
                if(i==0){
                    maxLeft=B[j-1];
                }else if(j==0){
                    maxLeft=A[i-1];
                }else {
                    maxLeft=Math.max(B[j-1],A[i-1]);
                }

                if((m+n)%2==1){
                    return maxLeft;
                }

                int minRight=0;
                if(i==m){
                    minRight=B[j];
                }else if(j==n){
                    minRight=A[i];
                }else {
                    minRight=Math.min(B[j],A[i]);
                }
                return (minRight+maxLeft)/2.0;
            }
        }
        return 0.0;
    }
}
